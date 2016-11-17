package name.martingeisse.sensemaker.core;

import com.google.inject.Singleton;

/**
 * The "plugin" that provides core functionality.
 */
public final class CorePlugin extends Plugin {

	@Override
	protected void configure() {
		defineExtensionPoint(Rule.class);
		bind(Engine.class).in(Singleton.class);
		bind(Controller.class).to(Engine.class).in(Singleton.class);
	}

}
