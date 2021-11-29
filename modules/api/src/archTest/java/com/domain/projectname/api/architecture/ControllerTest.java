package com.domain.projectname.api.architecture;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.core.domain.JavaParameter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;

import static com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith;
import static com.tngtech.archunit.lang.conditions.ArchConditions.*;
import static com.tngtech.archunit.lang.conditions.ArchPredicates.are;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static java.lang.String.format;

@AnalyzeClasses(packages = "com.domain.projectname.api")
public class ControllerTest {

	@ArchTest
	public ArchRule be_interface = classes()
			.that().resideInAPackage("..controllers..")
			.should().beInterfaces();

	@ArchTest
	public ArchRule have_name = classes()
			.that().resideInAPackage("..controllers..")
			.should().haveSimpleNameEndingWith("Controller");

	@ArchTest
	public ArchRule be_mapped = classes()
			.that().resideInAPackage("..controllers..")
			.should().beAnnotatedWith(RequestMapping.class);

	@ArchTest
	public ArchRule no_entity = classes()
			.that().resideInAPackage("..controllers..")
			.should(not(accessClassesThat(are(annotatedWith(Entity.class)))));

	@ArchTest
	public ArchRule method_mapping = methods()
			.that().areDeclaredInClassesThat().resideInAPackage("..controllers..")
			.should().beAnnotatedWith(RequestMapping.class)
			.orShould().beAnnotatedWith(GetMapping.class)
			.orShould().beAnnotatedWith(DeleteMapping.class)
			.orShould().beAnnotatedWith(PutMapping.class)
			.orShould().beAnnotatedWith(PostMapping.class)
			.orShould().beAnnotatedWith(PatchMapping.class);

	@ArchTest
	public ArchRule body_param_valid = methods()
			.that().areDeclaredInClassesThat().resideInAPackage("..controllers..")
			.and(hasParametersThat(are(annotatedWith(RequestBody.class))))
			.should(haveParametersThat(are(annotatedWith(Valid.class))));

	private DescribedPredicate<JavaMethod> hasParametersThat(DescribedPredicate<? super JavaParameter> are) {
		return new DescribedPredicate<>(
				format("have parameters that %s", are.getDescription())
		) {
			@Override
			public boolean apply(JavaMethod item) {
				return item.getParameters().stream().anyMatch(are::apply);
			}
		};
	}

	private ArchCondition<? super JavaMethod> haveParametersThat(DescribedPredicate<? super JavaParameter> are) {
		return new ArchCondition<>("have parameters that " + are.getDescription()) {
			@Override
			public void check(JavaMethod item, ConditionEvents events) {
				boolean pass = item.getParameters().stream().anyMatch(are::apply);
				events.add(new SimpleConditionEvent(
						item, pass,
						format(
								"%s does %shave parameters that %s %s",
								item.getDescription(),
								pass ? "" : "not ",
								are.getDescription(), item.getSourceCodeLocation()
						)
				));
			}
		};
	}
}
