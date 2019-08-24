package P1918;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 제목 : 후위 표기식
 * URL : https://www.acmicpc.net/problem/1918
 * 종류 : 스택
 * 예시 :
 * A+(B*(C*D+(F-G))+E)
 * (A+(B*C))-(D/E)
 * (A+B-C)*D+E
 * A*B/C
 * A*(B+C)
 * A*B+C+D
 * A*B-C+D
 */
public class Main {

	static Map<String, Integer> priorityMap = new HashMap<>();

	static {
		priorityMap.put(")", 0);
		priorityMap.put("(", 3);
		priorityMap.put("+", 1);
		priorityMap.put("-", 1);
		priorityMap.put("*", 2);
		priorityMap.put("/", 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] a = s.toCharArray();
		Stack<String> b = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			if (65 <= a[i] && a[i] <= 90) {
				System.out.print(a[i]);
			} else if (a[i] == ')') {
				while (!b.isEmpty()) {
					String k = b.pop();
					if (k.equals("(")) break;
					System.out.print(k);
				}
			} else {
				while (!b.isEmpty() && !b.peek().equals("(") && priority(String.valueOf(a[i]), b.peek())) {
					System.out.print(b.pop());
				}
				b.push(String.valueOf(a[i]));
			}
		}
		while (!b.isEmpty()) {
			System.out.print(b.pop());
		}
	}

	private static boolean priority(String op1, String op2) {
		if (priorityMap.get(op1) <= priorityMap.get(op2)) return true;
		return false;
	}
}