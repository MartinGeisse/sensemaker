package name.martingeisse.sensemaker.plugins.file;

import name.martingeisse.sensemaker.core.ItemKey;
import name.martingeisse.sensemaker.core.ItemProvider;

import java.io.File;

/**
 *
 */
public class FileStatisticsProvider implements ItemProvider {

	@Override
	public <T> T get(ItemKey<T> key) {
		if (key instanceof FileStatisticsKey) {
			return (T)getFileStatistics(new File("."));
		}
		return null;
	}

	private FileStatistics getFileStatistics(File node) {
		if (node.isDirectory()) {
			FileStatistics statistics = new FileStatistics(0, 1);
			for (File subNode : node.listFiles()) {
				statistics = statistics.add(getFileStatistics(subNode));
			}
			return statistics;
		} else if (node.isFile()) {
			return new FileStatistics(1, 0);
		} else {
			return new FileStatistics(0, 0);
		}
	}

}
