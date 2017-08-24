package p4948;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> m = new ArrayList<>();
		while (true) {
			int n = sc.nextInt();
			if (n == 0) break;
			m.add(n);
		}

		for (int j = 0; j < m.size(); j++) {
			int l = m.get(j);
			int t = 0;
			for (int k = l + 1; k <= 2 * l; k++) {
				if (primary(k)) t++;
			}
			System.out.println(t);
		}
	}

	private static boolean primary(int i) {
		if (i < 2) return false;
		int d = (int) Math.sqrt(i);
		for (int j = 2; j <= d; j++) {
			if (i % j == 0) return false;
		}
		return true;
	}
}