package name.martingeisse.sensemaker.plugins.java;

import name.martingeisse.sensemaker.core.ItemKey;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * Represents a list of the names of all subtypes of a specific type (class or interface). This list does not
 * include the name of the type to look for, only proper subtypes.
 */
public final class TypeHierarchyKey implements ItemKey<List<String>> {

	private final String fullName;
	private final Kind kind;

	public TypeHierarchyKey(String fullName, Kind kind) {
		this.fullName = fullName;
		this.kind = kind;
	}

	/**
	 * Getter method.
	 *
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Getter method.
	 *
	 * @return the kind
	 */
	public Kind getKind() {
		return kind;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof TypeHierarchyKey) && (((TypeHierarchyKey) obj).fullName.equals(fullName)) && ((TypeHierarchyKey)obj).kind == kind;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(fullName).append(kind).toHashCode();
	}

	/**
	 * Specifies the kind of related types to return.
	 */
	public static enum Kind {

		/**
		 * Returns only the direct superclass for each class. Returns an empty list for class Object and for interfaces.
		 */
		DIRECT_SUPERCLASS,

		/**
		 * Returns all ancestor classes for each class, including class Object. Returns an empty list for class Object
		 * and for interfaces (even though each implementation must extend Object, this is not returned for interfaces).
		 */
		ANCESTOR_CLASSES,

		/**
		 * For a class, returns the direct subclasses. For an interface, returns the classes directly implementing
		 * the interface.
		 */
		DIRECT_SUBCLASSES,

		/**
		 * Returns the same classes as DIRECT_SUBCLASSES, as well as all their descendant classes.
		 */
		DESCENDANT_CLASSES,

		/**
		 * For a class, returns all interfaces directly implemented by that class. For an interface, returns the
		 * direct superinterfaces.
		 */
		DIRECT_SUPERINTERFACES,

		/**
		 * Returns the same interfaces as DIRECT_SUPERINTERFACES as well as all their ancestor interfaces.
		 */
		ANCESTOR_INTERFACES,

		/**
		 * For a class, this always returns an empty list. For an interface, returns the list of all direct subinterfaces.
		 */
		DIRECT_SUBINTERFACES,

		/**
		 * For a class, this always returns an empty list. For an interface, returns all descendant interfaces.
		 */
		DESCENDANT_INTERFACES,

		/**
		 * Returns the union of ANCESTOR_CLASSES and ANCESTOR_INTERFACES.
		 */
		SUPERTYPES,

		/**
		 * Returns the union of DESCENDANT_INTERFACES and the results of DESCENDANT_CLASSES for all those interfaces.
		 */
		SUBTYPES;

	}

}
