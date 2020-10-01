package p2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int k;
	static int[] m;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = new int[n];
		v = new boolean[n];
		for (int i = 0; i < n; i++) m[i] = Integer.parseInt(br.readLine());
		dfs();
		System.out.println(k);
		for (int i = 0; i < n; i++) {
			if (v[i]) System.out.println(i + 1);
		}
	}

	private static void dfs() {
		var idx = 0;
		var target = 0;
		for (int i = 1; i <= n; i++) {
			idx = i;
			target = i;
			var dep = 0;
			do {
				dep++;
				target = m[target - 1];
			} while (idx != target && dep < n);
			if (idx == target) {
				k++;
				v[idx - 1] = true;
			}
		}
	}
}