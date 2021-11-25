package com.domain.projectname.api.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

import static com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith;
import static com.tngtech.archunit.lang.conditions.ArchConditions.*;
import static com.tngtech.archunit.lang.conditions.ArchPredicates.are;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.domain.projectname.api")
public class ControllerTest {

	@ArchTest
	public ArchRule be_interface = classes()
			.that().resideInAPackage("..controller..")
			.should().beInterfaces();

	@ArchTest
	public ArchRule have_name = classes()
			.that().resideInAPackage("..controller..")
			.should().haveSimpleNameEndingWith("Controller");

	@ArchTest
	public ArchRule be_mapped = classes()
			.that().resideInAPackage("..controller..")
			.should().beAnnotatedWith(RequestMapping.class);

	@ArchTest
	public ArchRule no_entity = classes()
			.that().resideInAPackage("..controller..")
			.should(not(accessClassesThat(are(annotatedWith(Entity.class)))));

	@ArchTest
	public ArchRule method_mapping = methods()
			.that().areDeclaredInClassesThat().resideInAPackage("..controller..")
			.should().beAnnotatedWith(RequestMapping.class)
			.orShould().beAnnotatedWith(GetMapping.class)
			.orShould().beAnnotatedWith(DeleteMapping.class)
			.orShould().beAnnotatedWith(PutMapping.class)
			.orShould().beAnnotatedWith(PostMapping.class)
			.orShould().beAnnotatedWith(PatchMapping.class);
}
