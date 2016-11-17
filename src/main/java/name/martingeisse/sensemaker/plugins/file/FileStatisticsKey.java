package name.martingeisse.sensemaker.plugins.file;

import name.martingeisse.sensemaker.old_core.ItemKey;

/**
 *
 */
public final class FileStatisticsKey implements ItemKey {

	@Override
	public boolean equals(Object obj) {
		return obj instanceof FileStatisticsKey;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
