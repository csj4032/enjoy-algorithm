package p1966;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = 0;
			int r = 0;

			Queue<Integer> q = new PriorityQueue(n);

			for (int j = 0; j < n; j++) {
				int p = sc.nextInt();
				if (p > k) k = p;
				if (j == i) r = p;
				q.add(p);
			}

			int y = 0;
			while (!q.isEmpty()) {
				if (q.peek() == r && q.peek() == k && m == y) {
					System.out.println(y+1);
					break;
				}
			}
		}
	}
}