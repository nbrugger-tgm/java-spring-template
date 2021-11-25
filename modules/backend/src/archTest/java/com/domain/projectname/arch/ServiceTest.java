package com.domain.projectname.arch;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.AccessTarget;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.elements.GivenClassesConjunction;
import com.tngtech.archunit.lang.syntax.elements.GivenFieldsConjunction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import static com.domain.projectname.arch.MethodConditions.beOverridden;
import static com.tngtech.archunit.core.domain.AccessTarget.Predicates.declaredIn;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo;
import static com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith;
import static com.tngtech.archunit.core.domain.properties.HasName.Predicates.name;
import static com.tngtech.archunit.lang.conditions.ArchConditions.*;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static java.lang.String.format;

@AnalyzeClasses(packages = "com.domain.projectname",
                importOptions = {ImportOption.DoNotIncludeTests.class})
public class ServiceTest {
	public DescribedPredicate<JavaClass> serviceInterface =
			JavaClass.Predicates.INTERFACES
					.and(JavaClass.Predicates.resideInAPackage("..services.."))
					.as("are Service Interfaces");

	public GivenFieldsConjunction serviceImplFields =
			fields().that().areDeclaredInClassesThat().areAnnotatedWith(Service.class);

	public DescribedPredicate<JavaClass> areServiceImpl =
			JavaClass.Predicates.TOP_LEVEL_CLASSES
					.and(annotatedWith(Service.class))
					.as("are Service Implementations");


	public DescribedPredicate<? super AccessTarget> save = declaredIn(assignableTo(
			CrudRepository.class)).and(name("save")).as("repository save method");

	public GivenClassesConjunction services = classes().that(areServiceImpl);


	@ArchTest
	public ArchRule in_package = services
			.should().resideInAPackage("..services..");

	@ArchTest
	public ArchRule use_interface = services
			.should().implement(serviceInterface)
			.because("Each Service should have an Interface defining the methods/functions");

	@ArchTest
	public ArchRule impl_naming = services
			.should().haveSimpleNameEndingWith("Impl")
			.because("Each Service's name should end with Impl by convention");

	@ArchTest
	public ArchRule service_type = services
			.should().bePackagePrivate()
			//disabled as (https://github.com/TNG/ArchUnit/issues/3) .andShould().onlyBeAccessed().byAnyPackage()
			.because("Service implementations should never be accessed directly");

	@ArchTest
	public ArchRule ctor = services.should(declareNumberOfConstructors(1));

	@ArchTest
	public ArchRule immutable = serviceImplFields.should()
	                                             .beFinal();
	@ArchTest
	public ArchRule fields_private = serviceImplFields.should()
	                                                  .bePrivate();
	@ArchTest
	public ArchRule package_clean = classes()
			.that()
			.resideInAPackage("..services..")
			.should(beInterfaces().and(bePublic()).or(beAnnotatedWith(Service.class)))
			.andShould().haveSimpleNameContaining("Service");

	@ArchTest
	public ArchRule no_additional_methods = methods()
			.that().areDeclaredInClassesThat(areServiceImpl)
			.and().arePublic()
			.should(beOverridden())
			.because("No service should add public methods");

	private ArchCondition<JavaClass> declareNumberOfConstructors(int i) {
		return new ArchCondition<>(format("declare exactly %d constructor(s)", i)) {
			@Override
			public void check(JavaClass item, ConditionEvents events) {
				int count = item.getConstructors().size();
				events.add(new SimpleConditionEvent(
						item, count == i,
						format(
								"%s declares exactly %d constructor(s) %s",
								item, i, item.getSourceCodeLocation()
						)
				));
			}
		};
	}

}
