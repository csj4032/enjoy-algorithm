package p1021;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = 0;
		int current = 1;
		int target = 0;
		int l[] = new int[10];

		for (int i = 1; i <= 10; i++) l[i - 1] = i;

		for (int i = 0; i < m; i++) {
			target = sc.nextInt();
			int index = Arrays.binarySearch(l, target);
			if (current == target) continue;

			n = n - 1;
		}

	}
}