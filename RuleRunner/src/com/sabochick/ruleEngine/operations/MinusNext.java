/*
 * 
 */
package com.sabochick.ruleEngine.operations;

import com.sabochick.ruleEngine.rules.Rule;

// TODO: Auto-generated Javadoc
/**
 * The Class MinusNext.
 */
public class MinusNext extends Operation {

	/**
	 * Instantiates a new minus next. MinusNext.execute(Rule rule) will contain
	 * logic for the operation. For the Integer[] present in
	 * rule.getVariables(), it will return true if Integer[i + 1] minus
	 * Integer[i] is greater than, less than, or equal to
	 * rule.getRightExpression() depending on the value in rule.getOperator().
	 *
	 * @param key
	 *            the key
	 */
	public MinusNext(String key) {
		super(key);
		// TODO Auto-generated constructor stub
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
				if (variables[i + 1] - variables[i] < Integer.parseInt(rule
						.getRightExpression())) {
					return true;
				}
			}
		} else if (rule.getOperator().equals(">")) {
			for (int i = 0; i < variables.length - 1; i++) {
				if (variables[i + 1] - variables[i] > Integer.parseInt(rule
						.getRightExpression())) {
					return true;
				}
			}
		} else if (rule.getOperator().equals("=")) {
			for (int i = 0; i < variables.length - 1; i++) {
				if (variables[i + 1] + variables[i] == Integer.parseInt(rule
						.getRightExpression())) {
					return true;
				}
			}
		}
		return false;
	}
}
