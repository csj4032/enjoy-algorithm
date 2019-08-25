package p1935;

import java.util.Scanner;
import java.util.Stack;

/**
 * 제목 : 후위 표기식2
 * 링크 : https://www.acmicpc.net/problem/1935
 */
public class Main {

	static double[] numbers;
	static Stack<Double> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String m = sc.next();
		initNumbers(sc, n);
		operation(m);
		System.out.println(String.format("%.2f", stack.peek()));
	}

	private static void operation(String m) {
		for (int i = 0; i < m.length(); i++) {
			char k = m.charAt(i);
			if (k != '+' && k != '-' && k != '*' && k != '/') {
				stack.push(numbers[k - 'A']);
			} else {
				Double p1 = stack.pop();
				Double p2 = stack.pop();
				calculate(p1, p2, k);
			}
		}
	}

	private static void initNumbers(Scanner sc, int n) {
		numbers = new double[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
	}

	private static void calculate(Double p1, Double p2, char k) {
		if (k == '+') {
			stack.push(p2 + p1);
		} else if (k == '-') {
			stack.push(p2 - p1);
		} else if (k == '*') {
			stack.push(p2 * p1);
		} else if (k == '/') {
			stack.push(p2 / p1);
		}
	}
}
