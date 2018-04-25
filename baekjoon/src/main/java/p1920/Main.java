package p1920;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map<BigInteger, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			map.put(new BigInteger(sc.next()), 1);
		}

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			if (map.containsKey(new BigInteger(sc.next()))) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
