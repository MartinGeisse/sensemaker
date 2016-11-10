package name.martingeisse.sensemaker.core;

/**
 * A key that is used to request an item from the {@link Database}. Item keys must be immutable data objects that
 * support hashCode() and equals(). They are parameterized with the type of item they represent.
 */
public interface ItemKey<T> {

	public int hashCode();
	public boolean equals(Object obj);

}
