package name.martingeisse.sensemaker.core;

import name.martingeisse.sensemaker.core.pattern.Pattern;

/**
 * A rule brings {@link Pattern}s -- which match {@link Finding}s -- together with code that consumes those findings
 * to produce new findings.
 *
 * Rules should be immutable and thread-safe. In particular, a rule must not keep internal state based on the findings
 * made. Keep in mind that a rule may be applied speculatively on findings not yet made, or be used on findings later
 * found to be false.
 */
public interface Rule {

	public Pattern[] getPatterns();

	public void consume(Finding[] matchedFindings);

}
