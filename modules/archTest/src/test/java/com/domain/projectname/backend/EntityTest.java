package com.domain.projectname.backend;

import com.domain.projectname.entities.BaseEntity;
import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import javax.persistence.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.domain.projectname",
                importOptions = {ImportOption.DoNotIncludeTests.class})
public class EntityTest {

	public static final DescribedPredicate<? super JavaClass> areEntities = new DescribedPredicate<>(
			"are entity classes") {
		@Override
		public boolean apply(JavaClass input) {
			return input.isAssignableTo(BaseEntity.class) && !input.isEquivalentTo(BaseEntity.class);
		}
	};

	@ArchTest
	public ArchRule extend_base_entity_class = classes()
			.that(areEntities)
			.or().areAnnotatedWith(Entity.class)
			.or().areAnnotatedWith(MappedSuperclass.class)
			.or().areAnnotatedWith(Embeddable.class)
			.or().areAnnotatedWith(EmbeddedId.class)
			.should().resideInAPackage("..entities..");

	@ArchTest
	public ArchRule not_define_additional_id_field = fields()
			.that().areDeclaredInClassesThat(areEntities)
			.should().notBeAnnotatedWith(Id.class)
			.because("id field should be defined in BaseEntity class not subclasses!" +
					         "Use UNIQUE instead");

	@ArchTest
	public ArchRule entities_annotated = classes()
			.that().resideInAPackage("..entities..")
			.should().be(BaseEntity.class)
			.orShould().beAnnotatedWith(Entity.class)
			.orShould().beAnnotatedWith(MappedSuperclass.class)
			.orShould().beAnnotatedWith(Embeddable.class)
			.orShould().beAnnotatedWith(EmbeddedId.class)
			.because("classes that don't have any of these annotations are not entities.");
}
