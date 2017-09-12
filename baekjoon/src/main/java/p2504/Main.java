package p2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().split("");
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
				String c = stack.pop();
				if (cur.equals(")")) {
					if (!stack.empty()) {
						k += calculator(2, stack, i, s, cur);
					} else if (s[i - 1].equals("(") && stack.empty()) {
						k += 2;
					}
				} else if (cur.equals("]")) {
					if (!stack.empty()) {
						k += calculator(3, stack, i, s, cur);
					} else if (s[i - 1].equals("[") && stack.empty()) {
						k += 3;
					}
				}
				if (c.equals("[") && cur.equals(")")) f = false;
				if (c.equals("(") && cur.equals("]")) f = false;
			}
		}
		if (stack.isEmpty() && f) {
			System.out.println(k);
		} else {
			System.out.println(0);
		}
	}

	private static Integer calculator(int k, Stack<String> stack, int i, String[] s, String cur) {
		if (s[i - 1].equals(cur)) return 0;
		for (int j = 0; j < stack.size(); j++) {
			k = k * (stack.get(j).equals("[") ? 3 : 2);
		}
		return k;
	}
}