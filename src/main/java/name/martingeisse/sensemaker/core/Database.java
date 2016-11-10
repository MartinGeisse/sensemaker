package name.martingeisse.sensemaker.core;

import java.util.NoSuchElementException;

/**
 * The main interface to the knowledge database.
 * <p>
 * This interface guarantees that the database itself is thread-safe. Implementations must obey this rule.
 * <p>
 * The returned items must be treated as immutable objects in a multithreaded context:
 * - client code must not modify items, even if possible
 * - items should be implemented as immutable classes whenever possible
 * - if an item appears immutable to the outside, but still keeps mutable state internally for optimization, then it
 * must handle that state in a thread-safe way.
 */
public interface Database {

	/**
	 * Fetches an item, producing it if necessary.
	 *
	 * @param key the item key
	 * @param <T> the item type
	 * @return the item
	 * @throws NoSuchItemException
	 */
	public <T> T get(ItemKey<T> key) throws NoSuchItemException;

}
