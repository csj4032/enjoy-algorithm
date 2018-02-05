import java.util.Stack;

public class Question3 {

	private static String OPEN = "(";
	private static String CLOSE = ")";
	private static String ZERO = "0";
	private static String ONE = "1";

	public static void main(String[] args) {
		int n = 4;
		int nn = n * 2;
		int form = (int) Math.pow(2, nn) - (int) Math.pow(2, nn - 1);
		int to = (int) Math.pow(2, 2 * n);
		for (int i = form; i < to; i++) {
			String s = String.format("%" + nn + "s", Integer.toBinaryString(i)).replace(" ", ZERO);
			if (isBracket(s)) {
				displayBracket(s);
			}
		}
	}

	private static void displayBracket(String s) {
		System.out.println(s.replaceAll(ONE, OPEN).replaceAll(ZERO, CLOSE));
	}

	private static boolean isBracket(String s) {
		String[] m = s.split("");
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < m.length; i++) {
			if (ONE.equals(m[i])) {
				stack.push(m[i]);
			} else {
				if (!stack.isEmpty() && !stack.peek().equals(m[i])) {
					stack.pop();
				} else {
					stack.push(m[i]);
				}
			}
		}
		return stack.isEmpty();
	}
}