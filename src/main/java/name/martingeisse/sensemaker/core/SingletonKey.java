package name.martingeisse.sensemaker.core;

/**
 * This key type can be used whenever only one key of a certain kind exists. Key equality is based on key object
 * identity, so the key must be made available as a singleton in this case. This is often done for the keys for
 * plugin-internal items to avoid creating lots of unnecessary key classes. It also makes it impossible to forge
 * a second instance of the key, alhtough the same effect could be achieved by making the key and item classes
 * package-private.
 */
public final class SingletonKey<T> implements ItemKey<T> {
}
