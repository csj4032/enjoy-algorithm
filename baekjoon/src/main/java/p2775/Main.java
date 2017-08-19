package p2775;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>(n);
			for (int j = 1; j <= n; j++) {
				list.add(j);
			}

			for (int l = 0; l < k; l++) {
				for (int m = 0; m < n-1; m++) {
					list.set(m + 1, list.get(m) + list.get(m + 1));
				}
			}

			System.out.println(list.get(n - 1));
		}
	}
}