import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LISPCalculator {

	static Node root = null;
	static Node current = null;
	static Node key = null;

	public static void main(String[] args) {
		final String ss = "(* (+ 2 3) (- 5 3))";
		final Pattern p = Pattern.compile("\\*|\\+|/|-(?!\\d)|-?\\d{1,30}|\\)");
		final Matcher m = p.matcher(ss);

		while (m.find()) {
			final String mg = m.group();
			if (mg.equals("*") || mg.equals("/") | mg.equals("+") | mg.equals("-")) {
				Node node = new Node(mg, new ArrayList<>());
				if (root == null) {
					root = node;
					current = node;
					key = node;
				} else if (current.left == null) {
					current.left = node;
					node.parent = current;
					key = node;
				} else if (current.right == null) {
					current.right = node;
					node.parent = current;
					key = node;
					current = current.left;
				}
			} else if (mg.equals(")")) {
				if (current.parent != null) current = current.parent;
				key = current;
			} else {
				key.numbers.add(Integer.valueOf(mg));
			}
		}

		recursive(root);
		String o = root.operation;
		System.out.println(root.numbers.stream().reduce((a, b) -> operation(a, b, o)).orElse(0));
	}

	private static void recursive(Node node) {
		if (node == null) return;
		recursive(node.left);
		recursive(node.right);
		node.result = node.numbers.stream().reduce((a, b) -> operation(a, b, node.operation)).orElse(0);
		if (node != root) node.parent.numbers.add(node.result);
	}

	private static Integer operation(Integer a, Integer b, String o) {
		if (o.equals("+")) return a + b;
		if (o.equals("-")) return a - b;
		if (o.equals("*")) return a * b;
		if (o.equals("/")) return a / b;
		return 0;
	}
}

class Node {
	Node left;
	Node right;
	Node parent = null;
	String operation;
	List<Integer> numbers;
	Integer result = 0;

	public Node(String operation, List<Integer> numbers) {
		this.operation = operation;
		this.numbers = numbers;
	}
}