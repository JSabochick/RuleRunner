/*
 * 
 */
package com.sabochick.ruleEngine.operations;

import com.sabochick.ruleEngine.rules.Rule;

// TODO: Auto-generated Javadoc
/**
 * The Class PlusNext.
 */
public class PlusNext extends Operation {

	/**
	 * Instantiates a new plus next. PlusNext.execute(Rule rule) contains the
	 * logic for the Operation. For the Integer[] present in rule.getVariables,
	 * will return true if Integer[i] plus Integer[i + 1] is less than, greater
	 * than, or equal to rule.getRightExpression depending on rule.getOperator()
	 *
	 * @param key
	 *            the key
	 */
	public PlusNext(String key) {
		super(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sabochick.ruleEngine.operations.Operation#execute(com.sabochick.
	 * ruleEngine.rules.Rule)
	 */
	@Override
	public boolean executeOperation(Rule rule) throws NullPointerException,
			IllegalStateException {
		if (rule == null) {
			throw new NullPointerException("Rule object is null");
		}
		if (rule.getVariables() == null || rule.getVariables().length == 0
				|| rule.getOperator() == null || rule.getOperator().isEmpty()
				|| rule.getRightExpression() == null
				|| rule.getRightExpression().isEmpty()) {
			throw new IllegalStateException(
					"Rule has not been initialized correctly.");
		}
		Integer[] variables = rule.getVariables();
		if (rule.getOperator().equals("<")) {
			for (int i = 0; i < variables.length - 1; i++) {
				if (variables[i] + variables[i + 1] < Integer.parseInt(rule
						.getRightExpression())) {
					return true;
				}
			}
		} else if (rule.getOperator().equals(">")) {
			for (int i = 0; i < variables.length - 1; i++) {
				if (variables[i] + variables[i + 1] > Integer.parseInt(rule
						.getRightExpression())) {
					return true;
				}
			}
		} else if (rule.getOperator().equals("=")) {
			for (int i = 0; i < variables.length - 1; i++) {
				if (variables[i] + variables[i + 1] == Integer.parseInt(rule
						.getRightExpression())) {
					return true;
				}
			}
		}
		return false;
	}
}
