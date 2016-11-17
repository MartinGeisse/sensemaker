package name.martingeisse.sensemaker.core;

import name.martingeisse.sensemaker.core.pattern.Pattern;

/**
 * This is an interface used purely for type-safety. It is implemented by any object which plugins use to describe an
 * observation made. Each finding is based on other findings -- the ones matched by {@link Pattern}s when it was made.
 * Each finding can in turn be matched by {@link Pattern}s to produce new findings.
 *
 * Findings should be immutable and thread-safe.
 */
public interface Finding {
}
