package name.martingeisse.sensemaker.plugins.java;

import name.martingeisse.sensemaker.core.SingletonKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
class InternalTypeHierarchyInfo {

	static final SingletonKey<InternalTypeHierarchyInfo> ITEM_KEY = new SingletonKey<>();

	final Map<String, String> classToDirectSuperclass = new HashMap<>();
	final Map<String, List<String>> classToAncestorsInOrder = new HashMap<>();
	final Map<String, List<String>> classToDirectSubclasses = new HashMap<>();
	final Map<String, List<String>> classToDescendants = new HashMap<>();
	final Map<String, List<String>> classOrInterfaceToDirectInterfaces = new HashMap<>();
	final Map<String, List<String>> classOrInterfaceToAncestorInterfaces = new HashMap<>();
	final Map<String, List<String>> interfaceToDirectSubinterfaces = new HashMap<>();
	final Map<String, List<String>> interfaceToDescendantInterfaces = new HashMap<>();
	final Map<String, List<String>> interfaceToDirectlyImplementingClasses = new HashMap<>();
	final Map<String, List<String>> interfaceToDescendantClasses = new HashMap<>();

	InternalTypeHierarchyInfo(List<ClassModel> classModels) {

	}

}
