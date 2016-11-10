package name.martingeisse.sensemaker.core;

import com.google.inject.Inject;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple in-memory implementation of the {@link Database}. Does not support item eviction and may therefore take
 * huge amounts of memory.
 */
public final class SimpleDatabase implements Database {

	private final Set<ItemProvider> itemProviders;

	private final ConcurrentHashMap<ItemKey<?>, Object> items = new ConcurrentHashMap<>();

	@Inject
	public SimpleDatabase(Set<ItemProvider> itemProviders) {
		this.itemProviders = itemProviders;
	}

	@Override
	public <T> T get(ItemKey<T> key) throws NoSuchItemException {
		T item = (T)items.get(key);
		if (item != null) {
			return item;
		}
		item = produceItem(key);
		if (item == null) {
			throw new NoSuchItemException(key);
		}
		Object previousItem = items.putIfAbsent(key, item);
		return (previousItem != null) ? (T)previousItem : item;
	}

	private <T> T produceItem(ItemKey<T> key) {
		ItemProvider foundProvider = null;
		T foundItem = null;
		for (ItemProvider provider : itemProviders) {
			T item = provider.get(key);
			if (item != null) {
				if (foundItem == null) {
					foundItem = item;
					foundProvider = provider;
				} else {
					throw new RuntimeException("got multiple items for key " + key + " from providers " + provider + " and " + foundProvider);
				}
			}
		}
		return foundItem;
	}

}
