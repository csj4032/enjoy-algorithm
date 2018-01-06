package p1874;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack();
		Integer n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			stack.add(i);
		}
	}
}
