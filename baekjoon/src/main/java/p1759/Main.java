package p1759;

import java.util.*;

public class Main {

	private static int n;
	private static int m;
	private static String[] w;
	private static String[] z;
	private static boolean[] v;
	private static String moeum = "aeiou";
	private static List<String> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<>();
		n = sc.nextInt();
		m = sc.nextInt();
		w = new String[m];
		z = new String[n];
		v = new boolean[m];
		for (int i = 0; i < m; i++) {
			w[i] = sc.next();
		}
		code(0, 0);
		list.sort(Comparator.naturalOrder());
		list.forEach(System.out::println);
	}

	private static void code(int k, int t) {
		if (k == n) {
			StringBuilder sb = new StringBuilder();
			String[] q = Arrays.copyOf(z, z.length);
			Arrays.sort(q);
			int mo = 0;
			for (int i = 0; i < q.length; i++) {
				if (moeum.contains(q[i])) mo++;
				sb.append(q[i]);
			}
			if (mo >= 1 && n - mo >= 2) list.add(sb.toString());
			return;
		}

		for (int i = t; i < m; i++) {
			if (!v[i]) {
				v[i] = true;
				z[k] = w[i];
				code(k + 1, i);
				v[i] = false;
			}
		}
	}
}
