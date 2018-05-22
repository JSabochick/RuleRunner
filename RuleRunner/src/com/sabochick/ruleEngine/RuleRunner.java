/*
 * 
 */
package com.sabochick.ruleEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sabochick.ruleEngine.operations.Average;
import com.sabochick.ruleEngine.operations.MinusNext;
import com.sabochick.ruleEngine.operations.Operations;
import com.sabochick.ruleEngine.operations.PlusNext;
import com.sabochick.ruleEngine.rules.Rule;
import com.sabochick.ruleEngine.rules.Rules;

public class RuleRunner {

	public static void main(String[] args) {
		Integer[] variables = new Integer[args.length];
		variables = RuleRunner.parseStringArgsToIntegers(args);
		String expression1 = "A + NEXT > 999";
		String expression2 = "NEXT - A > 499";
		String expression3 = "AVERAGE > 499";
		Operations operations = Operations.INSTANCE;
		Rules rules = Rules.INSTANCE;
		operations.registerOperation(new PlusNext("A + NEXT"));
		operations.registerOperation(new MinusNext("NEXT - A"));
		operations.registerOperation(new Average("AVERAGE"));

		Rule rule1 = new Rule("Rule1").addExpression(expression1);
		Rule rule2 = new Rule("Rule2").addExpression(expression2);
		Rule rule3 = new Rule("Rule3").addExpression(expression3);

		rules.registerRule(rule1);
		rules.registerRule(rule2);
		rules.registerRule(rule3);

		action(variables, rules);
	}

	private static Integer[] parseStringArgsToIntegers(String[] args)
			throws NumberFormatException {
		Integer[] nums = new Integer[args.length];
		for (int i = 0; i < args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		return nums;
	}

	private static void action(Integer[] variables, Rules rules) {
		boolean quit = false;
		if (!quit) {
			try {
				if (variables.length == 0 || variables[0] == null) {
					System.out
							.println("No arguments found. Please provide integer arguments");
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(System.in));
					String arguments = reader.readLine();
					variables = parseStringArgsToIntegers(arguments.split(" "));
				}
				rules.addVariablesToAllRules(variables);

				rules.runAllRules();

				System.out.println("Run Again?(Y or N)");
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));
				if (reader.readLine().equalsIgnoreCase("y")) {
					variables = new Integer[100];
					action(variables, rules);
				} else {
					quit = true;
					System.out.println("Exiting");
				}

			} catch (IllegalArgumentException | IOException e) {
				if (e instanceof NumberFormatException) {
					System.out
							.println("Please only enter integers as arguments");
					variables = new Integer[100];
					action(variables, rules);
				} else{
					System.out.println("Exception Message: " + e.getMessage());
					e.printStackTrace(System.out);
				}
			}
		}
	}
}
