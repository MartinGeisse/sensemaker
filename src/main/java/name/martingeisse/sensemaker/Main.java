package name.martingeisse.sensemaker;

import com.google.inject.Guice;
import com.google.inject.Injector;
import name.martingeisse.sensemaker.core.Database;
import name.martingeisse.sensemaker.plugins.PluginList;
import name.martingeisse.sensemaker.plugins.file.FileStatisticsKey;

/**
 *
 */
public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(PluginList.getPlugins());
		System.out.println(injector.getInstance(Database.class).get(new FileStatisticsKey()));
	}

}
