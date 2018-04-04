package p10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack();
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			String n = sc.next();
			if (n.equals("0")) {
				stack.pop();
			} else {
				stack.push(n);
			}
		}
		System.out.println(stack.stream().mapToInt(e -> Integer.parseInt(e)).sum());
	}
}