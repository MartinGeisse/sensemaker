package name.martingeisse.sensemaker.plugins.java;

import name.martingeisse.sensemaker.core.ItemKey;
import name.martingeisse.sensemaker.plugins.file.FileStatisticsKey;

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
