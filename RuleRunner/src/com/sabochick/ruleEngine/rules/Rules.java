/*
 * 
 */
package com.sabochick.ruleEngine.rules;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Enum Rules. Used as a container to store Rule objects Provides methods to
 * add a rule to the container, and run all rules present in container
 * 
 */
public enum Rules {

	INSTANCE;

	private ArrayList<Rule> rules = new ArrayList<Rule>();

	/**
	 * Flag to signify if all rules present in the container pass Will be set to
	 * true by the runAllRules() method
	 */
	private boolean isAllRulesPass = false;

	/**
	 * Clear rules. empties container
	 */
	public void clearRules() {
		this.rules = new ArrayList<Rule>();
		this.isAllRulesPass = false;
	}

	/**
	 * Register rule. Adds a rule to the container
	 * 
	 * @param rule
	 *            the rule
	 */
	public void registerRule(Rule rule) {
		if (!rules.contains(rule)) {
			rules.add(rule);
		}

	}

	/**
	 * Run all rules. Will run all rules in the container If a rule passes, it
	 * will print a success message to System.out If all rules in container
	 * pass, it will also print a success message
	 */
	public void runAllRules() {
		for (Rule r : rules) {
			if (r.run()) {
				System.out.println(r.getName() + " " + "passed.");
				isAllRulesPass = true;
			} else
				isAllRulesPass = false;
		}
		if (isAllRulesPass) {
			System.out.println("All Rules passed.");
		}
	}

	/**
	 * Sets Rule.variables (private field on Rule, accessible by
	 * rule.getVariables()) equal to the provided Integer[] for every Rule in
	 * container
	 * 
	 *
	 * @param variables
	 *            the variables
	 */
	public void addVariablesToAllRules(Integer[] variables) {
		for (Rule r : rules) {
			r.addVariables(variables);
		}

	}
}
