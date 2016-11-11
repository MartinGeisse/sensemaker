package name.martingeisse.sensemaker.plugins.java;

import name.martingeisse.sensemaker.core.ItemProvider;
import name.martingeisse.sensemaker.core.Plugin;
import name.martingeisse.sensemaker.plugins.file.FileStatisticsProvider;

/**
 *
 */
public class JavaPlugin extends Plugin {

	@Override
	protected void configure() {
		extend(ItemProvider.class, ClassModelProvider.class);
	}

}
