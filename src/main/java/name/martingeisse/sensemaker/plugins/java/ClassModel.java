package name.martingeisse.sensemaker.plugins.java;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.objectweb.asm.tree.ClassNode;

import java.util.List;

/**
 *
 */
public final class ClassModel {

	private final String packageName;
	private final String simpleName;
	private final ClassNode asmClassNode;

	public ClassModel(String packageName, String simpleName, ClassNode asmClassNode) {
		this.packageName = packageName;
		this.simpleName = simpleName;
		this.asmClassNode = asmClassNode;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof ClassModel) && ((ClassModel) obj).packageName.equals(packageName) && ((ClassModel) obj).simpleName.equals(simpleName);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(packageName).append(simpleName).toHashCode();
	}

	/**
	 * Getter method.
	 *
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * Getter method.
	 *
	 * @return the simpleName
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * Getter method.
	 *
	 * @return the fullName
	 */
	public String getFullName() {
		return packageName.isEmpty() ? simpleName : (packageName + '.' + simpleName);
	}

	/**
	 * Getter method.
	 *
	 * @return the asmClassNode
	 */
	public ClassNode getAsmClassNode() {
		return asmClassNode;
	}

	public ClassModelKey getSuperclassKey() {
		return new ClassModelKey(asmClassNode.superName);
	}

	public ClassModelKey[] getInterfaceKeys() {
		List<String> interfaceNames = asmClassNode.interfaces;
		ClassModelKey[] result = new ClassModelKey[interfaceNames.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = new ClassModelKey(interfaceNames.get(i));
		}
		return result;
	}

}
