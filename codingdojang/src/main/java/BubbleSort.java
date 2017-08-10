import java.util.Scanner;

import static java.lang.System.in;

public class BubbleSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int n = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) a[i] = sc.nextInt();

		int swap = 0, loop = 0;

		for (int i = 0; i < n - 1; i++) {
			int count = swap;
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					int t = a[j + 1];
					a[j + 1] = a[j];
					a[j] = t;
					swap = swap + 1;
				}
			}
			loop = loop + 1;
			if (count == swap) break;
		}

		System.out.println(loop + " " + swap);
	}
}
