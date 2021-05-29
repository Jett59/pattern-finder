package app.cleancode.pattern_finder.tree;

import app.cleancode.pattern_finder.tree.FormularTree.FormularElement.Operation;

public class FormularTree {
public static class FormularElement {
	public FormularElement next;
	public FormularTree nextTree;
	public final int arg;
	public final Operation operation;
	
	public FormularElement(Operation operation, int arg) {
		this.arg = arg;
		this.operation = operation;
	}
	
	public static enum Operation {
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE,
		POWER
	}
}
public final FormularElement first;

public FormularTree(int initialNumber) {
	first = new FormularElement(Operation.PLUS, initialNumber);
}

public int evaluate (int n) {
	int result = 0;
	FormularElement next = first;
	while (next != null) {
		int arg = next.arg;
		if (arg == Integer.MIN_VALUE && next.nextTree != null) {
			arg = next.nextTree.evaluate(n);
		}
		switch (next.operation) {
		case PLUS: {
			result += arg;
			break;
		}
		case MINUS: {
			result -= arg;
			break;
		}
		case MULTIPLY: {
			result *= arg;
			break;
		}
		case DIVIDE: {
			result /= arg;
			break;
		}
		case POWER: {
			result = (int) Math.pow(result, arg);
			break;
		}
		}
		next = next.next;
	}
	return result;
}
}