package name.martingeisse.sensemaker.plugins.java;

import name.martingeisse.sensemaker.core.ItemProvider;
import name.martingeisse.sensemaker.core.Plugin;

/**
 *
 */
public class JavaPlugin extends Plugin {

	@Override
	protected void configure() {
		extend(ItemProvider.class, JavaProvider.class);
	}

}
