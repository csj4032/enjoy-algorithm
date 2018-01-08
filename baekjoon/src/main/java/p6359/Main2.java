package p6359;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer t = sc.nextInt();
		while (t-- > 0) {
			int i, j, n = sc.nextInt();
			int[] d = new int[n + 1];
			d[0] = 0;
			for (i = 1; i <= n; i++) {
				for (j = 1; i * j <= n; j++) {
					if (d[i * j] != 0) {
						d[i * j] = 0;
					} else {
						d[i * j] = 1;
					}
				}
			}
			System.out.println(Arrays.stream(d).filter(e -> e > 0).count());
		}
		sc.close();
	}
}
