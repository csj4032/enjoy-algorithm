package p2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().split("");
		Stack<String> stack1 = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		Stack<String> stack3 = new Stack<>();
		String prev = "";
		String cur = "";
		for (int i = 0; i < s.length; i++) {
			cur = s[i];
			if (cur.equals("(")) {
				stack1.push(cur);
			} else {
				stack2.push("2");
				prev = cur;
			}
		}

		System.out.println(stack2);
	}
}