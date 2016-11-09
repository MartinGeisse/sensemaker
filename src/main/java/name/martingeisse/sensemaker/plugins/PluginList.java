package name.martingeisse.sensemaker.plugins;

import name.martingeisse.sensemaker.core.CorePlugin;
import name.martingeisse.sensemaker.core.Plugin;

/**
 *
 */
public final class PluginList {

	// prevent instantiation
	private PluginList() {
	}

	/**
	 * @return
	 */
	public static Plugin[] getPlugins() {
		return new Plugin[] {new CorePlugin()};
	}

}
