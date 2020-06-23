package p1067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	private static int n;
	private static Integer[] l;
	private static long m = 0l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		LinkedList<Integer> deque = new LinkedList();
		l = new Integer[n];

		String[] x = br.readLine().split(" ");
		String[] y = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			Integer x1 = Integer.valueOf(x[i]);
			Integer y1 = Integer.valueOf(y[i]);
			deque.add(x1);
			l[i] = y1;
		}

		for (int i = 0; i < n; i++) {
			deque.addLast(deque.poll());
			m = Math.max(m, cal(deque, l));
		}
		System.out.println(m);
	}

	private static long cal(LinkedList<Integer> deque, Integer[] l) {
		long sum = 0;
		for (int i = 0; i < n; i++) sum += l[i] * deque.get(i);
		return sum;
	}
}