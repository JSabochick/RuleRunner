/*
 * 
 */
package com.sabochick.ruleEngine.operations;

import java.util.HashMap;
import java.util.Map;

import com.sabochick.ruleEngine.rules.Rule;

// TODO: Auto-generated Javadoc
/**
 * The Enum Operations. A container for Operation object.
 */
public enum Operations {

	INSTANCE;

	/**
	 * The operations. maps an Operation to a key. The key should equal a
	 * Rule.getLeftExpression() value
	 * */
	private final Map<String, Operation> operations = new HashMap<>();

	/**
	 * Register operation. adds and Operation to the container
	 * 
	 * @param op
	 *            the op
	 */
	public void registerOperation(Operation op) {
		if (!operations.containsKey(op.getKey())) {
			operations.put(op.getKey(), op);
		}
	}

	/**
	 * Gets the operation. Used by Rule.run(). For the rule object passed in,
	 * rule.getLeftExpression() needs to equal an Operation.getKey() present in
	 * the container
	 *
	 * @param rule
	 *            the rule
	 * @return the operation
	 */
	public Operation getOperation(Rule rule) throws IllegalArgumentException {
		if (operations.isEmpty()) {
			throw new IllegalArgumentException(
					"No operations present in container. Add an Operation using Operations.registerOperation(Operation op)");
		}
		Operation op = this.operations.get(rule.getLeftExpression());
		return op;
	}
}
