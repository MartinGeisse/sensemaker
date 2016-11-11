package name.martingeisse.sensemaker.plugins.java;

import com.google.inject.Inject;
import name.martingeisse.sensemaker.core.Database;
import name.martingeisse.sensemaker.core.ItemKey;
import name.martingeisse.sensemaker.core.ItemProvider;
import name.martingeisse.sensemaker.util.UnexpectedExceptionException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class JavaProvider implements ItemProvider {

	private static final String CLASS_FILE_NAME_SUFFIX = ".class";

	private final Database database;

	@Inject
	public JavaProvider(Database database) {
		this.database = database;
	}

	@Override
	public <T> T get(ItemKey<T> key) {
		if (key instanceof ClassModelKey) {
			return (T)getClassModel((ClassModelKey)key);
		} else if (key instanceof AllClassModelsKey) {
			return (T)getAllClassModels();
		} else if (key instanceof TypeHierarchyKey) {
			return (T)getSubtypes((TypeHierarchyKey)key);
		}
		return null;
	}

	private ClassModel getClassModel(ClassModelKey key) {
		for (ClassModel classModel : database.get(new AllClassModelsKey())) {
			if (classModel.getFullName().equals(key.getFullName())) {
				return classModel;
			}
		}
		return null;
	}

	private List<ClassModel> getAllClassModels() {
		try {
			File rootFolder = new File("build/classes");
			List<ClassModel> result = new ArrayList<>();
			findClassModels(null, rootFolder, result);
			return result;
		} catch (IOException e) {
			throw new UnexpectedExceptionException(e);
		}
	}

	private void findClassModels(String packageName, File packageFolder, List<ClassModel> result) throws IOException {
		for (File entry : packageFolder.listFiles()) {
			String filename = entry.getName();
			if (entry.isFile() && filename.endsWith(CLASS_FILE_NAME_SUFFIX)) {
				String baseFilename = filename.substring(0, filename.length() - CLASS_FILE_NAME_SUFFIX.length());
				result.add(readClassModel(packageName, baseFilename, entry));
			} else if (entry.isDirectory() && filename.indexOf('.') == -1) {
				String subpackageName = (packageName == null ? filename : (packageName + '.' + filename));
				findClassModels(subpackageName, entry, result);
			}
		}
	}

	private ClassModel readClassModel(String packageName, String simpleName, File file) throws IOException {
		ClassNode classNode = new ClassNode();
		try (InputStream inputStream = new FileInputStream(file)) {
			new ClassReader(inputStream).accept(classNode, 0);
		}
		return new ClassModel(packageName, simpleName, classNode);
	}

	private List<String> getSubtypes(TypeHierarchyKey key) {
		List<ClassModel> allClassModels = database.get(new AllClassModelsKey());


	}

}
