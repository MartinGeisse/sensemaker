package name.martingeisse.sensemaker.plugins.java;

import name.martingeisse.sensemaker.core.Database;
import name.martingeisse.sensemaker.core.ItemKey;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;

/**
 * Queries {@link ClassModel}s based on the Java type hierarchy from the {@link Database}. Since type hierarchy based
 * queries can be very complex, this object encapsulates the necessary low-level item queries.
 *
 * This is not a query "builder"; methods may already execute parts of the query. You should avoid using an instance
 * of this class and then throwing it away if the result isn't actually needed, since that affects performance.
 *
 * This object is stateful. It keeps the "current result" of the query. Methods may change that result and/or return
 * new query objects.
 */
public final class TypeHierarchyQuery {

	private final Database database;
	private final Map<String, ClassModel> classModelsByName;

	public TypeHierarchyQuery(Database database) {
		this.database = database;
		this.classModelsByName = new HashMap<>();
	}

	public void add(ClassModel classModel) {
		classModelsByName.put(classModel.getFullName(), classModel);
	}

	public void addAll(Collection<ClassModel> set) {
		for (ClassModel classModel : set) {
			add(classModel);
		}
	}

	public void add(String className) {
		ClassModel classModel = database.get(new ClassModelKey(className));
		if (classModel == null) {
			throw new IllegalArgumentException("class not found: " + className);
		}
		classModelsByName.put(className, classModel);
	}

	public void remove(ClassModel classModel) {
		classModelsByName.remove(classModel.getFullName());
	}

	public void removeAll(Collection<ClassModel> set) {
		for (ClassModel classModel : set) {
			remove(classModel);
		}
	}

	public void remove(String className) {
		classModelsByName.remove(className);
	}

	public void clear() {
		classModelsByName.clear();
	}

	/**
	 * Performs the specified step for all current elements and replaces them by the results of the step.
	 */
	public void replaceBy(Step step) {
		Set<ClassModel> stepResult = getStep(step);
		clear();
		addAll(stepResult);
	}

	/**
	 * Performs the specified step for all current elements and adds the result as new current elements.
	 */
	public void extendBy(Step step) {
		addAll(getStep(step));
	}

	/**
	 * Performs extendBy(step) repeatedly until no new elements are found.
	 */
	public void closure(Step step) {
		Collection<ClassModel> previousStepResult = classModelsByName.values();
		while (true) {
			Set<ClassModel> stepResult = getStep(step);
			if (stepResult.isEmpty()) {
				break;
			}
			addAll(stepResult);
			previousStepResult = stepResult;
		}
	}

	/**
	 * Performs the specified step for all current elements and removes the results from the current elements.
	 */
	public void reduceBy(Step step) {
		removeAll(getStep(step));
	}

	private Set<ClassModel> getStep(Step step) {
		return getStep(classModelsByName.values(), step);
	}

	private Set<ClassModel> getStep(Collection<ClassModel> origin, Step step) {
		Set<ClassModel> result = new HashSet<>();
		for (ClassModel originClassModel : origin) {
			result.addAll(getStep(originClassModel.getFullName(), step));
		}
		return result;
	}

	private Set<ClassModel> getStep(String originClassName, Step step) {
		return database.get(new StepKey(originClassName, step));
	}


	public static enum Step {

		/**
		 * For classes, steps to the direct superclass. Yields no result for interfaces (not even class Object, even
		 * though each interface implementation has to extend Object).
		 */
		SUPERCLASS,

		/**
		 * For classes, steps to the direct subclasses. For interfaces, steps to all classes directly implementing
		 * the interface.
		 */
		SUBCLASS,

		/**
		 * For classes, steps to the directly implemented interfaces (does not include superinterfaces of directly
		 * implemented interfaces nor directly implemented interfaces of superclasses).
		 *
		 * For interfaces, steps to the direct superinterfaces.
		 */
		SUPERINTERFACE,

		/**
		 * Yields no result for classes. For interfaces, steps to direct subinterfaces.
		 */
		SUBINTERFACE;

	}

	private static final class StepKey implements ItemKey<Set<ClassModel>> {

		private final String originClassName;
		private final Step step;

		StepKey(String originClassName, Step step) {
			this.originClassName = originClassName;
			this.step = step;
		}

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof StepKey) && ((StepKey)obj).originClassName.equals(originClassName) && ((StepKey)obj).step == step;
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(originClassName).append(step).toHashCode();
		}

	}

}
