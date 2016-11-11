package name.martingeisse.sensemaker.util;

/**
 * Wraps an unexpected, usually checked, exception as an unchecked one.
 */
public class UnexpectedExceptionException extends RuntimeException {

	public UnexpectedExceptionException(Throwable cause) {
		super("unexpected exception", cause);
	}

	public UnexpectedExceptionException(String message, Throwable cause) {
		super(message, cause);
	}

}
