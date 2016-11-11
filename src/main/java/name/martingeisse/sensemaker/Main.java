package name.martingeisse.sensemaker;

import com.google.inject.Guice;
import com.google.inject.Injector;
import name.martingeisse.sensemaker.core.Database;
import name.martingeisse.sensemaker.plugins.PluginList;
import name.martingeisse.sensemaker.plugins.file.FileStatisticsKey;
import name.martingeisse.sensemaker.plugins.java.AllClassModelsKey;
import name.martingeisse.sensemaker.plugins.java.ClassModel;

/**
 *
 */
public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(PluginList.getPlugins());
		Database database = injector.getInstance(Database.class);
		System.out.println(database.get(new FileStatisticsKey()));
		System.out.println();
		System.out.println("--- java classes ---");
		System.out.println();
		for (ClassModel classModel : database.get(new AllClassModelsKey())) {
			System.out.println("class " + classModel.getFullName());
			System.out.println("\tpackage: " + classModel.getPackageName());
			System.out.println("\tsimple name: " + classModel.getSimpleName());
			System.out.println();
		}
	}

}
