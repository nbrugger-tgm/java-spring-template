package com.domain.projectname.backend;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.base.HasDescription;
import com.tngtech.archunit.core.domain.*;
import com.tngtech.archunit.core.domain.properties.HasType;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import javax.persistence.Entity;

import static com.domain.projectname.arch.MethodConditions.*;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.core.domain.properties.HasName.Predicates.nameEndingWith;
import static com.tngtech.archunit.lang.SimpleConditionEvent.*;
import static com.tngtech.archunit.lang.conditions.ArchPredicates.are;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.domain.projectname")
public class DtoTest {

	private final DescribedPredicate<JavaClass> DTOs =
			resideInAPackage("..dto..").or(resideInAPackage("..models.."))
			                           .and(nameEndingWith("Dto").or(nameEndingWith("DTO")))
			                           .as("DTOs");


	@ArchTest
	private ArchRule chores_methods =
			classes().that(are(DTOs)).should(declareMethodThat(isHashCode))
			         .andShould(declareMethodThat(isEquals))
			         .andShould(declareMethodThat(isToString))
			         .because("it makes the objects behave correctly," +
					                  " and is easy to do with @EqualsAndHashCode and @ToString");

	@ArchTest
	private ArchRule not_entity =
			classes().that(are(DTOs)).should().notBeAnnotatedWith(Entity.class)
			         .as("DTOs should not be entities");


	@ArchTest
	private ArchRule fields =
			fields().that().areDeclaredInClassesThat(are(DTOs)).and().areNotStatic()
			        .should().notBeFinal()
			        .as("no instance variables in DTOs should be final")
			        .because("Entity to DTO mapping requires non-final fields");

	@ArchTest
	private ArchRule constants =
			fields().that().areDeclaredInClassesThat(are(DTOs)).and().areStatic()
			        .should().beFinal()
			        .because("DTOs are not meant to hold a static state");

	@ArchTest
	private ArchRule no_public    =
			noFields().that().areDeclaredInClassesThat(are(DTOs))
			          .and().areNotFinal()
			          .should().bePublic();
	@ArchTest
	private ArchRule needs_fields =
			classes().that(are(DTOs)).should(declareFields());
	@ArchTest
	private ArchRule no_dto       =
			noFields().that().areDeclaredInClassesThat(are(DTOs))
			          .should(beInstancesOfClassesThat(EntityTest.areEntities));

	private ArchCondition<? super JavaClass> declareFields() {
		return new ArchCondition<>("declare fields") {
			@Override
			public void check(JavaClass item, ConditionEvents events) {
				boolean hasFields = item
						.getFields()
						.stream()
						.anyMatch(f -> !f.getModifiers().contains(JavaModifier.STATIC));
				events.add(new SimpleConditionEvent(
						item,
						hasFields,
						"has " + (hasFields ? "" : "no ") + "fields"
				));
			}
		};
	}

	private <T extends HasType & HasDescription> ArchCondition<T> beInstancesOfClassesThat(
			DescribedPredicate<? super JavaClass> classCondition
	) {
		return new ArchCondition<>("should be of a type that " + classCondition.getDescription()) {
			@Override
			public void check(T item, ConditionEvents events) {
				if (!classCondition.apply(item.getRawType())) {
					events.add(violated(
							item,
							"the type of " + item.getDescription() + " is not " + classCondition.getDescription()
					));
				} else {
					events.add(satisfied(
							item,
							"the type of " + item.getDescription() + " is " + classCondition.getDescription()
					));
				}
			}
		};
	}

	private ArchCondition<? super JavaMethod> modifyAnyFieldThat(DescribedPredicate<? super JavaField> fieldCondition) {
		return new ArchCondition<>("modify a field that " + fieldCondition.getDescription()) {
			@Override
			public void check(JavaMethod item, ConditionEvents events) {
				boolean modified = item
						.getFieldAccesses()
						.stream()
						.filter(ac -> fieldCondition.apply(ac.getTarget().resolveField().get()))
						.anyMatch(ac -> ac.getAccessType() == JavaFieldAccess.AccessType.SET);
				if (!modified) {
					events.add(violated(
							item,
							"the method " + item.getDescription() + " does not modify a field that " + fieldCondition.getDescription()
					));
				} else {
					events.add(satisfied(
							item,
							"the method " + item.getDescription() + " modifies a field that " + fieldCondition.getDescription()
					));
				}
			}
		};
	}

}
