/*
 * 
 */
package com.sabochick.ruleEngine.parser;

import com.sabochick.ruleEngine.rules.Rule;

// TODO: Auto-generated Javadoc
/**
 * The Class ExpressionParser. Used to parse the String present in
 * Rule.getExpression();
 */
public class ExpressionParser {
	// splits the String Rule.expression into a left operator, operation, right
	// operation
	// example: "A + NEXT > 100" -> left = "A + NEXT" , operator = ">", right =

	private static String[] splitExpression;

	/**
	 * Interpret. Splits the string returned by rule.getExpression() into
	 * rule.getLeftExpression(), rule.getOperator(), and
	 * rule.getRightExpression().
	 * 
	 * The String rule.getExpression() should be of the following format
	 * [leftExpression that matches an Operation.getKey] [Operator equal to "&gt;", "&lt;",
	 * or "="] [A constant]
	 * 
	 * Example: if rule.getExpression() equivalent to "A + NEXT &gt; 100"
	 * rule.getLeftExpression() will equal "A + NEXT", rule.getOperator() will
	 * equal "&gt;", rule.getRightExpression() will equal "100"
	 *
	 * @param rule
	 *            the rule
	 * @return the rule
	 */
	public static Rule interpretRuleExpression(Rule rule) throws IllegalArgumentException {
		if (rule.getExpression().isEmpty() || rule.getExpression() == null) {
			throw new IllegalArgumentException(
					"rule.getExpression() must be defined before running ExpressionParser.interpret(Rule rule)");
		}
		if (rule.getExpression().split("<").length > 1) {
			splitExpression = rule.getExpression().split("<");
			rule.setOperator("<");
			rule.setLeftExpression(splitExpression[0].trim());
			rule.setRightExpression(splitExpression[1].trim());
			return rule;
		} else if (rule.getExpression().split(">").length > 1) {
			splitExpression = rule.getExpression().split(">");
			rule.setOperator(">");
			rule.setLeftExpression(splitExpression[0].trim());
			rule.setRightExpression(splitExpression[1].trim());
			return rule;
		} else if (rule.getExpression().split("=").length > 1) {
			splitExpression = rule.getExpression().split("=");
			rule.setOperator("=");
			rule.setLeftExpression(splitExpression[0].trim());
			rule.setRightExpression(splitExpression[1].trim());
			return rule;
		} else {
			throw new IllegalArgumentException(
					"Error: Unable to parse expression" + " "
							+ rule.getExpression());
		}

	}
}
