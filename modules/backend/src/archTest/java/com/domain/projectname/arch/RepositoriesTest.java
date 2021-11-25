package com.domain.projectname.arch;

import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAnyPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.domain.projectname",
                importOptions = {ImportOption.DoNotIncludeTests.class})
public class RepositoriesTest {
	@ArchTest
	public ArchRule just_interfaces = classes()
			.that().resideInAPackage("..repositories..")
			.should().beInterfaces()
			.because("Repositories should not be implemented");

	@ArchTest
	public ArchRule annotation = classes()
			.that().resideInAPackage("..repositories..")
			.should().beAnnotatedWith(Repository.class)
			.because("The annotation is needed for spring to pick up the class");

	@ArchTest
	public ArchRule extend_repo = classes()
			.that().resideInAPackage("..repositories..")
			.should().beAssignableTo(CrudRepository.class);

	@ArchTest
	public ArchRule naming = classes()
			.that().resideInAPackage("..repositories..")
			.should().haveSimpleNameEndingWith("Repository");

	@ArchTest
	public ArchRule access = classes()
			.that().resideInAPackage("..repositories..")
			.should().onlyAccessClassesThat(resideInAnyPackage("..repositories..", "..entities.."))
			.because("Repositories can only depend on entities");

	@ArchTest
	public ArchRule no_impl = methods()
			.that().areDeclaredInClassesThat().resideInAPackage("..repositories..")
			.should().haveModifier(JavaModifier.ABSTRACT)
			.orShould().haveModifier(JavaModifier.BRIDGE)
			.because("Repositories should not be implemented");
}
