package p10813;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nn = new int[n];

		for (int i = 0; i < n; i++) {
			nn[i] = i + 1;
		}

		for (int i = 0; i < m; i++) {
			int p = sc.nextInt() - 1;
			int q = sc.nextInt() - 1;
			int pv = nn[p];
			int qv = nn[q];
			nn[p] = qv;
			nn[q] = pv;
		}

		System.out.println(Arrays.stream(nn).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}