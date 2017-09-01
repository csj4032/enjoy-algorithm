package p1003;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 제목 : 구현
 * 단계 : 피보나치 함수
 * 힌트 :
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			Map<Integer, Integer> m = new HashMap<>();
			m.put(0, 0);
			m.put(1, 0);
			fibonacci(n, m);
			System.out.println(m.get(0) + " " + m.get(1));
		}
	}

	private static int fibonacci(int n, Map<Integer, Integer> m) {
		if (n == 0) {
			m.put(0, m.get(0) + 1);
			return 0;
		}
		if (n == 1) {
			m.put(1, m.get(1) + 1);
			return 1;
		}
		return fibonacci(n - 1, m) + fibonacci(n - 2, m);
	}
}
