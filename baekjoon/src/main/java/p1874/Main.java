package p1874;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		List<String> operations = new ArrayList<>();
		int n = sc.nextInt();
		int m = 0;
		int top = 0;
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if (k >= top) {
				while (true) {
					if (k > m) {
						m++;
						operations.add("+");
						stack.push(m);
					} else {
						operations.add("-");
						stack.pop();
						top = stack.isEmpty() ? 0 : stack.peek();
						break;
					}
				}
			} else if (k < top) {
				operations.clear();
				operations.add("NO");
				break;
			}
		}

		for (String operation : operations) {
			System.out.println(operation);
		}
	}
}