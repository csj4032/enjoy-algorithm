package p1874;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		List<String> string = new ArrayList<>();
		int n = sc.nextInt();
		int index;
		int max = 0;
		int k;
		while (0 < n--) {
			k = sc.nextInt();
			if (max < k) {
				for (index = max; index < k; index++) {
					stack.push(index + 1);
					string.add("+");
				}
			} else {
				if (stack.peek() > k) {
					System.out.println("NO");
					return;
				}
			}
			stack.pop();
			string.add("-");
			if (max < k) max = k;
		}
		string.stream().forEach(System.out::println);
	}
}