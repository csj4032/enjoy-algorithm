package p2581;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		List<Integer> l = new ArrayList<>();
		for (int i = m; i <= n; i++) {
			if (prime(i)) {
				l.add(i);
			}
		}
		int sum = l.stream().mapToInt(Integer::valueOf).sum();
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(l.get(0));
		}
	}

	private static boolean prime(int i) {
		if (i < 2) return false;
		int s = (int) Math.sqrt(i);
		for (int j = 2; j <= s; j++) {
			if (i % j == 0) return false;
		}
		return true;
	}
}