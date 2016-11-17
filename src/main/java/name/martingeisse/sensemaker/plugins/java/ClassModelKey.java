package name.martingeisse.sensemaker.plugins.java;

import name.martingeisse.sensemaker.old_core.ItemKey;

/**
 *
 */
public final class ClassModelKey implements ItemKey<ClassModel> {

	private final String fullName;

	public ClassModelKey(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Getter method.
	 *
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof ClassModelKey) && (((ClassModelKey) obj).fullName.equals(fullName));
	}

	@Override
	public int hashCode() {
		return fullName.hashCode();
	}

}
