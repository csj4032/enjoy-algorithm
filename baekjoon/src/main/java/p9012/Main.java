package p9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			if (parenthesis(str)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean parenthesis(String str) {
		String[] parent = str.split("");
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < parent.length; i++) {
			if ("(".equals(parent[i])) {
				stack.push("(");
			} else {
				if (stack.isEmpty()) return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}