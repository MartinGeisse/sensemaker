package name.martingeisse.sensemaker.core;

import com.google.inject.Singleton;
import name.martingeisse.sensemaker.plugins.file.FileStatisticsProvider;

/**
 * The "plugin" that provides core functionality.
 */
public final class CorePlugin extends Plugin {

	@Override
	protected void configure() {

		defineExtensionPoint(ItemProvider.class);
		extend(ItemProvider.class, FileStatisticsProvider.class);

		bind(Database.class).to(SimpleDatabase.class).in(Singleton.class);
	}

}
