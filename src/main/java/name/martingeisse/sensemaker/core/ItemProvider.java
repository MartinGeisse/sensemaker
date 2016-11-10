package name.martingeisse.sensemaker.core;

/**
 * This is an extension point.
 *
 * This object provides missing items for the {@link Database}.
 *
 * In general, providers cannot tell in advance if they are able to provide items. They can only know this by trying.
 * This gives maximum freedom to the implementation. In the future, specific providers may be able to give additional
 * information to speed up the lookup process. Item providers are not allowed to rely on such optimizations, though:
 * Even if all such optimizations are turned off, and the engine thus asks each provider for each item, the
 * non-ambiguity rule below must not be violated.
 *
 * Multiple providers may be able to provide items for the same item type, or key type. However, it is not possible
 * for multiple providers to provide an item for the same specific key, otherwise the key would be ambiguous and the
 * whole knowledge-finding process could not work. If the engine ever finds two different providers returning an item
 * for the same key, it stops with an exception. (Note, though, that the engine is not required to find all such
 * errors).
 */
public interface ItemProvider {

	/**
	 * Tries to obtain an item from this provider. Returns null if this provider cannot provide the item.
	 */
	public <T> T get(ItemKey<T> key);

}
