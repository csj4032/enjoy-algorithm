package kakaoInternship2020;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximizeFormulas {

	private Pattern pattern = Pattern.compile("([\\d]+)|([\\*\\-\\+])");
	private List<String> expressions = new ArrayList<>();
	private long max = 0l;

	public long reward(String expression) {
		Matcher matcher = pattern.matcher(expression);
		while (matcher.find()) expressions.add(matcher.group());
		permutation(new String[]{"-", "+", "*"}, 3, 3, 0);
		return Math.abs(max);
	}

	private void permutation(String[] operations, int c, int r, int depth) {
		if (r == depth) {
			List<String> expression = new ArrayList<>(expressions);
			for (int i = 0; i < operations.length; i++) {
				String targetOp = operations[i];
				for (int j = 0; j < expression.size(); j++) {
					if (expression.get(j).equals("*") | expression.get(j).equals("+") | expression.get(j).equals("-")) {
						long a = Long.parseLong(expression.get(j - 1));
						String op = expression.get(j);
						long b = Long.parseLong(expression.get(j + 1));
						if (op.equals(targetOp)) {
							long ab = calculator(a, b, op);
							expression.remove(j - 1);
							expression.remove(j - 1);
							expression.remove(j - 1);
							expression.add(j - 1, String.valueOf(ab));
							j = j - 1;
						}
					}
				}
			}
			long sum = Long.parseLong(expression.get(0));
			if (Math.abs(max) < Math.abs(sum)) max = sum;
			return;
		}

		for (int i = depth; i < c; i++) {
			swap(operations, depth, i);
			permutation(operations, c, r, depth + 1);
			swap(operations, i, depth);
		}
	}

	private long calculator(long a, long b, String op) {
		if (op.equals("+")) return a + b;
		if (op.equals("-")) return a - b;
		return a * b;
	}

	private void swap(String[] operations, int r, int depth) {
		String p = operations[r];
		String q = operations[depth];
		operations[r] = q;
		operations[depth] = p;
	}
}
