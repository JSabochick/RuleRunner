/*
 * 
 */
package com.sabochick.ruleEngine.operations;

import com.sabochick.ruleEngine.rules.Rule;

// TODO: Auto-generated Javadoc
/**
 * The Class Average.
 */
public class Average extends Operation {

	/**
	 * Instantiates a new average object. Average.execute(Rule rule) contains
	 * the logic for the Average operation. Will find the average value of the
	 * Integer[] in Rule.getVariables(). Depending on the value of
	 * rule.getOperator(), it will return true if average is less than, greater
	 * than, or equal to Rule.getRightExpression()
	 *
	 * @param key
	 *            the key
	 */
	public Average(String key) {
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
		Integer total = 0;
		Integer average = 0;
		for (Integer i : variables) {
			total += i;
		}
		average = (total / variables.length);
		if (rule.getOperator().equals("<")) {
			if (average < Integer.parseInt(rule.getRightExpression())) {
				return true;
			}
		} else if (rule.getOperator().equals(">")) {
			if (average > Integer.parseInt(rule.getRightExpression())) {
				return true;
			}
		} else if (rule.getOperator().equals("=")) {
			if (average == Integer.parseInt(rule.getRightExpression())) {
				return true;
			}
		}
		return false;
	}

}
