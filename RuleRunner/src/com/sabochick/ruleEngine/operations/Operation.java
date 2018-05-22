/*
 * 
 */
package com.sabochick.ruleEngine.operations;

import com.sabochick.ruleEngine.rules.Rule;

// TODO: Auto-generated Javadoc
/**
 * The Abstract Class Operation. Any subclass will need to define the execute()
 * method which should contain the logic of the subclass.
 */
public abstract class Operation {

	/**
	 * The key. The key should equal a Rule.getLeftExpression() value;
	 * */
	String key;

	/**
	 * Execute. Should contain the logic for the Operation extending this class
	 *
	 * @param rule
	 *            the rule
	 * @return true, if successful
	 */
	public abstract boolean executeOperation(Rule rule);

	/**
	 * Instantiates a new operation. The key should equal a
	 * Rule.getLeftExpression() value;
	 * 
	 * @param key
	 *            the key
	 */
	public Operation(String key) {
		this.key = key;
	}

	/**
	 * Gets the key that will be used to store the operation in the map that
	 * exists in the Operations container
	 *
	 * @return the key
	 */
	public String getKey() {
		return this.key;
	}
}
