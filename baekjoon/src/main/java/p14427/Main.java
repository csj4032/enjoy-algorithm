package p14427;

import java.util.Scanner;

public class Main {

	static int n;
	static int[] nn;
	static int[] seg;
	static int m;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		nn = new int[10];
		seg = new int[4 * 10];
		for (int i = 0; i < n; i++) nn[i] = sc.nextInt();
		init(0, n - 1, 1);
		//System.out.println(Arrays.toString(seg));
		m = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < m; i++) {
			var s = sc.nextLine();
			if (s.length() == 1) {
				int q = query(0, n - 1, 1, 0, n - 1) + 1;
				System.out.println(q);
			} else {
				var ss = s.split(" ");
				var ii = Integer.parseInt(ss[1]);
				var v = Integer.parseInt(ss[2]);
				nn[ii - 1] = v;
				update(ii - 1, v, 1, 0, n - 1);
			}
		}
	}

	private static int midIdx(int a, int b) {
		if (a == -1) return b;
		if (b == -1) return a;
		return nn[a] <= nn[b] ? a : b;
	}

	private static int init(int l, int r, int node) {
		if (l == r) return seg[node] = l;
		var mid = (l + r) / 2;
		return seg[node] = midIdx(init(l, mid, node * 2), init(mid + 1, r, node * 2 + 1));
	}

	private static int query(int l, int r, int node, int nl, int nr) {
		if (r < nl || l > nr) return -1;
		if (l <= nl && nr <= r) return seg[node];
		var mid = (l + r) / 2;
		return midIdx(query(l, mid, node * 2, nl, nr), query(mid + 1, r, node * 2 + 1, nl, nr));
	}

	private static int update(int i, int v, int node, int l, int r) {
		if (i < l || i > r || l == r) return seg[node];
		var mid = (l + r) / 2;
		return seg[node] = midIdx(update(i, v, node * 2, l, mid), update(i, v, node * 2 + 1, mid + 1, r));
	}
}