package com.domain.projectname.api.architecture;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaAnnotation;
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
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
			.orShould().beAnnotatedWith(PatchMapping.class)
			.because("Controller interfaces should only contain path handlers");

	@ArchTest
	public ArchRule body_param_valid = methods()
			.that().areDeclaredInClassesThat().resideInAPackage("..controllers..")
			.should(not(haveParametersThat(
					are(annotatedWith(RequestBody.class)).and(areNot(annotatedWith(Valid.class))))
			));

	@ArchTest
	public ArchRule declared_inputs = noMethods()
			.that().areDeclaredInClassesThat().resideInAPackage("..controllers..")
			.should(haveParametersThat(areNot(
					annotatedWith(anyOf(
							RequestBody.class,
							CookieValue.class,
							RequestHeader.class,
							PathVariable.class,
							RequestParam.class,
							SessionAttribute.class,
							ModelAttribute.class,
							RequestAttribute.class
					))
			)))
			.because("Controller input needs to be readable from a request");

	private DescribedPredicate<? super JavaAnnotation<?>> anyOf(final Class<? extends Annotation>... annotations) {
		String rawAnnotationNames = Arrays.stream(annotations)
		                                  .map(Class::getSimpleName)
		                                  .collect(Collectors.joining(", "));
		return new DescribedPredicate<>(String.format("any of : %s", rawAnnotationNames)) {
			@Override
			public boolean apply(JavaAnnotation<?> input) {
				return Arrays.stream(annotations)
				             .anyMatch(i -> input.getRawType().isEquivalentTo(i));
			}
		};
	}

	private DescribedPredicate<? super JavaMethod> haveParameters() {
		return new DescribedPredicate<>("have parameters") {
			@Override
			public boolean apply(JavaMethod input) {
				return !input.getParameters().isEmpty();
			}
		};
	}

	private <T> DescribedPredicate<T> areNot(final DescribedPredicate<? super T> predicate) {
		return are(DescribedPredicate.not(predicate));
	}

	private DescribedPredicate<JavaMethod> hasParametersThat(
			DescribedPredicate<? super
					JavaParameter> are
	) {
		return new DescribedPredicate<>(
				format("have parameters that %s", are.getDescription())
		) {
			@Override
			public boolean apply(JavaMethod item) {
				return item.getParameters().stream().anyMatch(are::apply);
			}
		};
	}

	private ArchCondition<? super JavaMethod> haveParametersThat(
			DescribedPredicate<? super
					JavaParameter> are
	) {
		return new ArchCondition<>("have parameters that " + are.getDescription()) {
			@Override
			public void check(JavaMethod item, ConditionEvents events) {
				boolean pass = item.getParameters().stream().anyMatch(are::apply);
				events.add(new SimpleConditionEvent(
						item, pass,
						format(
								"%s does %shave parameters (%s) that %s %s",
								item.getDescription(),
								pass ? "" : "not ",
								pass ? item.getParameters()
								           .stream()
								           .filter(are::apply)
								           .map(this::paramToString)
								           .collect(Collectors.joining(", ")) :
										item.getParameters()
										    .stream()
										    .filter(Predicate.not(are::apply))
										    .map(this::paramToString)
										    .collect(Collectors.joining(", ")),
								are.getDescription(), item.getSourceCodeLocation()
						)
				));
			}

			private String paramToString(JavaParameter p) {
				return format(
						"[%d]%s",
						p.getIndex(),
						p.getType().getName()
				);
			}
		};
	}
}
