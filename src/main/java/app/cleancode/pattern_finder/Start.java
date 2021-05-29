package app.cleancode.pattern_finder;

import java.util.ArrayList;
import java.util.List;

public class Start {
public static void main(String[] args) {
	List<Double> pattern = new ArrayList<>();
	for (String arg : args) {
		pattern.add(Double.parseDouble(arg));
	}
	System.out.println(pattern);
}
}
