package name.martingeisse.sensemaker.plugins.file;

import name.martingeisse.sensemaker.core.ItemProvider;
import name.martingeisse.sensemaker.core.Plugin;

/**
 *
 */
public class FilePlugin extends Plugin {

	@Override
	protected void configure() {
		extend(ItemProvider.class, FileStatisticsProvider.class);
	}

}
