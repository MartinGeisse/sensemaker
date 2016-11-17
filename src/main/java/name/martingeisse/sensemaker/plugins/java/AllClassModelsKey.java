package name.martingeisse.sensemaker.plugins.java;

import name.martingeisse.sensemaker.old_core.ItemKey;

import java.util.List;

/**
 *
 */
public final class AllClassModelsKey implements ItemKey<List<ClassModel>> {

	@Override
	public boolean equals(Object obj) {
		return obj instanceof AllClassModelsKey;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
