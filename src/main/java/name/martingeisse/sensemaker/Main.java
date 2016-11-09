package name.martingeisse.sensemaker;

import com.google.inject.Guice;
import com.google.inject.Injector;
import name.martingeisse.sensemaker.plugins.PluginList;

/**
 *
 */
public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(PluginList.getPlugins());
		// TODO
	}

}
