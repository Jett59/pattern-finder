package app.cleancode.pattern_finder;

import java.util.ArrayList;
import java.util.List;

import app.cleancode.pattern_finder.tree.FormularTree;
import app.cleancode.pattern_finder.tree.TreeBuilder;

public class Start {
public static void main(String[] args) {
	List<Double> pattern = new ArrayList<>();
	for (String arg : args) {
		pattern.add(Double.parseDouble(arg));
	}
	System.out.println(pattern);
	TreeBuilder treeBuilder = new TreeBuilder();
	FormularTree tree = treeBuilder.newTree();
	for (int i = 0; i < 3; i ++) {
		treeBuilder.modifyTree(tree);
	}
	System.out.println(tree);
	int dif = 0;
	for (int n = 0; n < args.length; n ++) {
		double difference = Math.abs(tree.evaluate(n) - pattern.get(n));
		if (difference == Integer.MIN_VALUE) {
			difference = Integer.MAX_VALUE;
		}
		dif += difference;
	}
	System.out.println("pattern dif: " + dif);
}
}
