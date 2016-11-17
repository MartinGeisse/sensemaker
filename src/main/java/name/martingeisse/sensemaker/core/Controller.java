package name.martingeisse.sensemaker.core;

import java.util.Set;

/**
 * This interface is used as the entry point to the engine.
 *
 * The controller is implemented in a stateless, thread-safe way. That is, multiple "runs" can be performed in
 * parallel without problems (provided that all plugin-provided classes obey their interface contracts).
 */
public interface Controller {

	/**
	 * Builds the closure under application of all rules of the specified set of initial "findings", the assumptions
	 * made.
	 *
	 * @param assumptions the assumptions used as initial "findings" (not modified)
	 * @return the set of all findings that can be made by applying all rules repeatedly
	 */
	public Set<Finding> closure(Set<Finding> assumptions);

}
