package p1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	private static String[] strings;
	private static Map<Character, Integer> map = new HashMap<>();
	private static int n;
	private static int k;
	private static int max;
	private static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		strings = new String[n];
		for (int i = 0; i < n; i++) {
			strings[i] = br.readLine();
			for (int j = 0; j < strings[i].length(); j++) {
				map.put(strings[i].charAt(j), 0);
			}
		}
		k = map.size();
		numbers = new int[k];

		for (int i = 0; i < k; i++) numbers[i] = 9 - i;

		permutation(k, k, 0);
		System.out.println(max);
	}

	private static void permutation(int m, int k, int depth) {
		if (depth == m) {
			Iterator<Character> it = map.keySet().iterator();
			while (it.hasNext()) {
				map.replace(it.next(), numbers[--k]);
			}

			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				String t = strings[i];
				int b = 0;
				int c = 1;
				for (int j = t.length() - 1; j >= 0; j--) {
					b += map.get(t.charAt(j)) * c;
					c *= 10;
				}
				a[i] = b;
			}

			int q = 0;
			for (int i = 0; i < a.length; i++) q += a[i];
			max = Math.max(q, max);
			return;
		}

		for (int i = depth; i < m; i++) {
			swap(i, depth);
			permutation(m, k, depth + 1);
			swap(i, depth);
		}
	}

	private static void swap(int p, int q) {
		System.out.println(p + " " + q);
		int t = numbers[p];
		numbers[p] = numbers[q];
		numbers[q] = t;
	}
}
