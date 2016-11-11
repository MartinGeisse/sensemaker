package name.martingeisse.sensemaker.plugins.java;

import org.objectweb.asm.tree.ClassNode;

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

}
