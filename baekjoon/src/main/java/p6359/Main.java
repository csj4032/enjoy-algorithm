package p6359;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer t = sc.nextInt();

		while (t-- > 0) {
			int k = sc.nextInt();
			int[] r = new int[k];
			for (int j = 1; j <= k; j++) {
				for (int l = j; l <= k; l++) {
					if (l % j == 0) {
						r[l - 1] = r[l - 1] == 0 ? 1 : 0;
					}
				}
			}
			System.out.println(Arrays.stream(r).filter(e -> e > 0).count());
		}

		sc.close();
	}
}
