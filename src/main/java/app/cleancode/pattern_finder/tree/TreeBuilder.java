package app.cleancode.pattern_finder.tree;

import app.cleancode.pattern_finder.tree.FormularTree.FormularElement;
import app.cleancode.pattern_finder.tree.FormularTree.FormularElement.Operation;

public class TreeBuilder {
public FormularTree newTree () {
	return new FormularTree(Math.random() < 0.1 ? Integer.MIN_VALUE : (int)(Math.random() * 100));
			}
public void modifyTree (FormularTree tree) {
	if (Math.random() < 0.5) {
		tree.addNext(new FormularElement(Operation.values() [(int)(Math.random() * Operation.values().length)], Math.random() < 0.1 ? Integer.MIN_VALUE : (int)(Math.random() * 100)));
	}else {
		tree.last.arg = Math.random() < 0.1 ? Integer.MIN_VALUE : (int)(Math.random() * 100);
				tree.last.operation = Operation.values() [(int)(Math.random() * Operation.values().length)];
	}
}
}
