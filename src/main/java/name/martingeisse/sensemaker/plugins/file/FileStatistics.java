package name.martingeisse.sensemaker.plugins.file;

/**
 *
 */
public final class FileStatistics {

	private final int fileCount;
	private final int folderCount;

	public FileStatistics(int fileCount, int folderCount) {
		this.fileCount = fileCount;
		this.folderCount = folderCount;
	}

	/**
	 * Getter method.
	 *
	 * @return the fileCount
	 */
	public int getFileCount() {
		return fileCount;
	}

	/**
	 * Getter method.
	 *
	 * @return the folderCount
	 */
	public int getFolderCount() {
		return folderCount;
	}

	/**
	 * @param other
	 * @return
	 */
	public FileStatistics add(FileStatistics other) {
		return new FileStatistics(fileCount + other.fileCount, folderCount + other.folderCount);
	}

	@Override
	public String toString() {
		return "File statistics: " + fileCount + " files, " + folderCount + " folders.";
	}

}
