package p1966;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 제목 : 프린트 큐
 * 링크 : https://www.acmicpc.net/problem/1966
 * 분류 : 브루트 포스, 큐, 시뮬레이션
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			PriorityQueue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
			int[] l = new int[n];

			for (int j = 0; j < n; j++) {
				int p = sc.nextInt();
				queue.add(p);
				l[j] = p;
			}

			int q = 0;
			int w = 0;
			while (!queue.isEmpty()) {
				int k = queue.poll();
				while (true) {
					if (k == l[q % n]) {
						w++;
						l[q % n] = 0;
						if (q % n == m) {
							sb.append(w).append("\n");
						}
						q++;
						break;
					}
					q++;
				}
			}
		}
		System.out.println(sb.toString());
	}
}