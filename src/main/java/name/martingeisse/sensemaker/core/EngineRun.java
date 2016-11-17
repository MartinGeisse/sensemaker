package name.martingeisse.sensemaker.core;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * A "run" of the {@link Engine}. This class keeps all state to make the engine itself stateless and thus thread-safe.
 */
final class EngineRun {

	private final Set<Rule> rules;
	private final Set<Finding> assumptions;
	private final Set<Finding> findings; // includes assumptions

	public EngineRun(Set<Rule> rules, Set<Finding> assumptions) {
		this.rules = rules;
		this.assumptions = ImmutableSet.copyOf(assumptions);
		this.findings = new HashSet<>(this.assumptions);
	}

	/**
	 * Getter method.
	 *
	 * @return the rules
	 */
	public Set<Rule> getRules() {
		return rules;
	}

	/**
	 * Getter method.
	 *
	 * @return the findings
	 */
	public Set<Finding> getFindings() {
		return findings;
	}

	/**
	 * Getter method.
	 *
	 * @return the assumptions
	 */
	public Set<Finding> getAssumptions() {
		return assumptions;
	}

	/**
	 *
	 */
	public void compureClosure() {
		// TODO
	}

}
