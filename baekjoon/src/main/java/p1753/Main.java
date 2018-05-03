package p1753;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[][] ve;
	static int inf = 10000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int s = sc.nextInt();
		ve = new int[v][v];

		for (int i = 0; i < v; i++) {
			Arrays.fill(ve[i], inf);
		}

		for (int i = 0; i < e; i++) {
			int ss = sc.nextInt();
			int ee = sc.nextInt();
			int vv = sc.nextInt();
			ve[ss - 1][ee - 1] = vv;
		}

		System.out.println(Arrays.deepToString(ve));
	}
}
