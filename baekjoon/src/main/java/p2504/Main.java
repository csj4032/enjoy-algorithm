package p2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//String[] s = sc.next().split("");
		//String[] s = new String[]{"(", "(", ")", "[", "[", "]", "]", ")", "(", "[", "]", ")"};
		String[] s = new String[]{"(", "(", ")", ")"};
		Stack<String> stack = new Stack<>();
		String cur;
		Integer k = 0;
		boolean f = true;
		for (int i = 0; i < s.length; i++) {
			cur = s[i];
			if (cur.equals("(") || cur.equals("[")) {
				stack.push(cur);
			} else {
				if (stack.isEmpty()) {
					f = false;
					break;
				}
				if (cur.equals(")")) {
					if (stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					} else {
						calculator(stack, 2);
					}
				} else {
					if (stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					} else {
						//System.out.println(stack.peek());
					}
				}
			}
		}

		System.out.println(stack);
	}

	private static int calculator(Stack<String> stack, int value) {
		int result = 0;
		while (!stack.isEmpty()) {
			String top = stack.peek();
			if (top.equals("(")) {
				stack.pop();
				result *= value;
				stack.push(String.valueOf(result));
				break;
			} else {
				result += Integer.parseInt(stack.pop());
			}
		}
		return result;
	}
}