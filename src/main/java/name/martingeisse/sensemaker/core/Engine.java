package name.martingeisse.sensemaker.core;

import java.util.Set;

/**
 *
 */
class Engine implements Controller {

	private final Set<Rule> rules;

	public Engine(Set<Rule> rules) {
		this.rules = rules;
	}

	@Override
	public Set<Finding> closure(Set<Finding> assumptions) {
		EngineRun run = new EngineRun(rules, assumptions);
		run.compureClosure();
		return run.getFindings();
	}

}
