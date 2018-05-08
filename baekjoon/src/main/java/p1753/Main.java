package p1753;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static int inf = 10000000;
	private static int[][] ve;
	private static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int s = sc.nextInt();
		ve = new int[v + 1][v + 1];
		dist = new int[v + 1];

		Arrays.fill(dist, inf);

		for (int i = 0; i < e; i++) {
			int ss = sc.nextInt();
			int ee = sc.nextInt();
			int vv = sc.nextInt();
			ve[ss][ee] = vv;
		}

		dijkstra(s);
	}

	private static void dijkstra(int s) {
		dist[s] = 0;
	}
}
