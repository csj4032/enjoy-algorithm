package p2748;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 제목 : 피보나치 수 2
 * 단계 : 피보나치
 * 힌트 :
 */
public class Main {

	static Map<Integer, Long> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (Integer i = 0; i <= n; i++) {
			map.put(i, fibonacci(i));
		}
		System.out.println(map.get(n));
	}

	private static Long fibonacci(Integer n) {
		if (0 == n) return 0L;
		if (1 == n) return 1L;
		if (map.get(n) != null) return map.get(n);
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}