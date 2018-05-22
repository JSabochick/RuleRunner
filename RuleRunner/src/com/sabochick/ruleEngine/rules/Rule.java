/*
 * 
 */
package com.sabochick.ruleEngine.rules;

import com.sabochick.ruleEngine.operations.Operation;
import com.sabochick.ruleEngine.operations.Operations;
import com.sabochick.ruleEngine.parser.ExpressionParser;

// TODO: Auto-generated Javadoc
/**
 * The Class Rule.
 */
public class Rule {

	private String name;
	private Integer[] variables;
	private String expression;
	private String leftExpression;
	private String operator;
	private String rightExpression;
	private static final Operations operations = Operations.INSTANCE;

	/**
	 * Instantiates a new rule with the name provided
	 *
	 * @param name
	 *            the name
	 */
	public Rule(String name) {
		this.name = name;
	}

	/**
	 * Adds the unparsed expression to the rule.
	 *
	 * @param expression
	 *            the expression
	 * @return the rule
	 */
	public Rule addExpression(String expression) {
		this.expression = expression;
		return this;
	}

	/**
	 * Adds the variables for the associated Operation to use
	 *
	 * @param nums
	 *            the nums
	 * @return the rule
	 */
	public Rule addVariables(Integer[] nums) {
		this.variables = nums;
		return this;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the variables.
	 *
	 * @return the variables
	 */
	public Integer[] getVariables() {
		return this.variables;
	}

	/**
	 * Gets the expression.
	 *
	 * @return the expression
	 */
	public String getExpression() {
		return this.expression;
	}

	/**
	 * Gets the left expression.
	 *
	 * @return the left expression
	 */
	public String getLeftExpression() {
		return leftExpression;
	}

	/**
	 * Sets the left expression.
	 *
	 * @param leftExpression
	 *            the new left expression
	 */
	public void setLeftExpression(String leftExpression) {
		this.leftExpression = leftExpression;
	}

	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * Sets the operator.
	 *
	 * @param operator
	 *            the new operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * Gets the right expression.
	 *
	 * @return the right expression
	 */
	public String getRightExpression() {
		return rightExpression;
	}

	/**
	 * Sets the right expression.
	 *
	 * @param rightExpression
	 *            the new right expression
	 */
	public void setRightExpression(String rightExpression) {
		this.rightExpression = rightExpression;
	}

	/**
	 * Runs the rule. Parses the expression in rule.getExpression(), finds the
	 * correct Operation, and executes the logic present in the Operation on
	 * rule.getVariables()
	 *
	 * @return true, if successful
	 */
	public boolean run(){
		
		Rule rule = ExpressionParser.interpretRuleExpression(this);
		Operation operation = operations.getOperation(rule);
		return operation.executeOperation(rule);

	}
}
