package name.martingeisse.sensemaker.core;

/**
 * This exception type is thrown if an item  cannot be found in the database.
 */
public final class NoSuchItemException extends RuntimeException {

	private final ItemKey<?> key;

	public NoSuchItemException(ItemKey<?> key) {
		super("no such item: " + key);
		this.key = key;
	}

	/**
	 * Getter method.
	 *
	 * @return the key
	 */
	public ItemKey<?> getKey() {
		return key;
	}

}
