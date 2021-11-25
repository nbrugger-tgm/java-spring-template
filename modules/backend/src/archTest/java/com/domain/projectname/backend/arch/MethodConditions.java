package com.domain.projectname.backend.arch;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.*;
import com.tngtech.archunit.core.domain.properties.HasReturnType;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;

import java.util.List;
import java.util.stream.Collectors;

import static com.tngtech.archunit.core.domain.properties.HasParameterTypes.Predicates.rawParameterTypes;
import static com.tngtech.archunit.lang.SimpleConditionEvent.*;

public class MethodConditions {


	public static DescribedPredicate<? super JavaMethod> isToString = method(
			String.class,
			"toString"
	);
	public static DescribedPredicate<? super JavaMethod> isHashCode = method(
			int.class,
			"hashCode"
	);
	public static DescribedPredicate<? super JavaMethod> isEquals   = method(
			boolean.class,
			"equals",
			Object.class
	);

	private MethodConditions() {
	}

	public static ArchCondition<JavaCodeUnit> call(DescribedPredicate<? super AccessTarget> access) {
		return new ArchCondition<>("call " + access.getDescription()) {
			@Override
			public void check(JavaCodeUnit item, ConditionEvents events) {
				var matchingAccesses = item.getAccessesFromSelf()
				                           .stream()
				                           .map(JavaAccess::getTarget)
				                           .filter(access::apply)
				                           .collect(Collectors.toSet());
				for (var match : matchingAccesses) {
					events.add(satisfied(
							item,
							item.getDescription() + " does call " + match.getDescription()
					));
				}
				if (matchingAccesses.isEmpty()) {
					events.add(violated(item, "doesn't call " + access.getDescription()));
				}
			}

		};
	}

	public static ArchCondition<JavaMethod> beOverridden() {
		return new ArchCondition<>("be overridden") {
			@Override
			public void check(JavaMethod method, ConditionEvents events) {
				boolean isOverridden = method.getOwner().getAllRawInterfaces().stream()
				                             .anyMatch(c -> c.tryGetMethod(
						                             method.getName(),
						                             getTypeNames(method.getParameters())
				                             ).isPresent());

				if (!isOverridden) {
					events.add(violated(
							method, method.getDescription() + " is not overridden from an interface"
					));
				}
			}

			private String[] getTypeNames(List<JavaParameter> parameters) {
				return parameters.stream()
				                 .map(p -> p.getRawType().getName())
				                 .toArray(String[]::new);
			}
		};
	}

	public static ArchCondition<JavaMethod> onlyBeAccessedByMethods(
			DescribedPredicate<? super JavaMethod> methodPredicate
	) {
		return new ArchCondition<>("only be accessed by methods " + methodPredicate) {
			@Override
			public void check(JavaMethod item, ConditionEvents events) {
				List<JavaMethod> methods = item.getMethodCallsFromSelf()
				                               .stream()
				                               .map(JavaMethodCall::getTarget)
				                               .map(AccessTarget.MethodCallTarget::resolve)
				                               .map(JavaMethod.class::cast)
				                               .distinct()
				                               .collect(Collectors.toList());
				for (JavaMethod method : methods) {
					if (!methodPredicate.apply(method)) {
						events.add(violated(
								item,
								"should only be accessed by methods " + methodPredicate
						));
					}
				}
			}
		};
	}

	public static ArchCondition<JavaClass> declareMethodThat(DescribedPredicate<? super JavaMethod> method) {
		return new ArchCondition<>("declare a method that " + method.getDescription()) {

			@Override
			public void check(JavaClass item, ConditionEvents events) {
				if (item.getMethods().stream().noneMatch(method::apply)) {
					events.add(violated(
							item,
							item.getDescription() + " should contain a method that " + method.getDescription()
					));
				}
			}
		};
	}


	public static DescribedPredicate<JavaMethod> method(
			Class<?> returnType,
			String name,
			Class<?>... parameters
	) {
		return new DescribedPredicate<>(" is " + returnType.getSimpleName() + " " + name + "(" + parameters.length + " parameters)") {
			@Override
			public boolean apply(JavaMethod input) {
				return input.getName().equals(name) &&
						rawParameterTypes(parameters).apply(input) &&
						HasReturnType.Predicates.rawReturnType(returnType).apply(input);
			}
		};
	}
}
