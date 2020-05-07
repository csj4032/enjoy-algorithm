package p1015;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var p = new int[n];
		var a = new int[n];
		var b = new int[n];
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			a[i] = k;
			p[i] = k;
		}
		Arrays.sort(p);

		for (int i = 0; i < n; i++) {
			int idx = Arrays.binarySearch(p, a[i]);
			b[i] = idx;
		}

		var sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(b[i]);
			sb.append(" ");
		}

		System.out.println(sb.toString().trim());
	}

	public static class Pair {
		int idx;
		int value;

		Pair(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}
}