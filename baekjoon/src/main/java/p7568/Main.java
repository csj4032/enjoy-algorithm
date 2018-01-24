package p7568;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n][2];
		int[] l = new int[n];
		int[] k = new int[n];
		Arrays.fill(k, 1);

		for (int i = 0; i < n; i++) {
			m[i][0] = sc.nextInt();
			m[i][1] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (m[i][0] < m[j][0] && m[i][1] < m[j][1]) {
					k[i] = k[i] + 1;
				}
			}
		}

		//System.out.println(Arrays.deepToString(m));
		//System.out.println(Arrays.toString(l));
		//System.out.println(Arrays.toString(k));
		System.out.println(Arrays.stream(k).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining(" ")));
	}
}