package p12015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n + 1];
		int[] dp = new int[n + 1];

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			m[i] = sc.nextInt();
		}

		list.add(m[1]);

		for (int i = 2; i <= n; i++) {
			if (list.get(list.size()) < m[i]) {
				list.add(m[i]);
			} else {
				list.contains(m[i]);
			}
		}

		//System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.stream(dp).max().orElse(0));
	}
}