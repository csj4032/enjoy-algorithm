package p2960;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 에라토스테네스의 체
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> list = new ArrayList<>();

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j % i == 0 && !list.contains(j)) {
					list.add(j);
				}
			}
		}

		System.out.println(list.get(k - 1));
	}
}
