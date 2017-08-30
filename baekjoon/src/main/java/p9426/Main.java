package p9426;

import java.util.Scanner;

/**
 * 제목 : 중앙값 측정
 * 단계 : 정렬
 * 힌트 : Segment Tree, Fenwick Tree
 */
public class Main {

	static int[] ARRAY;
	static int[] TREE;
	static int MAX_N = 250001;
	static int MAX = 65536;
	static int N = 0;
	static int K = 0;
	static long RESULT = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		ARRAY = new int[MAX_N];
		TREE = new int[MAX_N * 8];

		for (int i = 0; i < N; i++) ARRAY[i] = sc.nextInt();
		for (int i = 0; i < K - 1; i++) update(ARRAY[i], 1, 1, 0, MAX - 1);

		for (int i = K - 1; i < N; i++) {
			update(ARRAY[i], 1, 1, 0, MAX - 1);
			RESULT += query((K + 1) / 2, 1, 0, MAX - 1);
			update(ARRAY[i - K + 1], -1, 1, 0, MAX - 1);
		}

		System.out.println(RESULT);
	}

	public static int update(long pos, long val, int node, long x, long y) {
		if (y < pos || pos < x) return TREE[node];
		if (x == y) return TREE[node] += val;
		long mid = (x + y) >> 1;
		return TREE[node] = update(pos, val, node * 2, x, mid) + update(pos, val, node * 2 + 1, mid + 1, y);
	}

	public static long query(int val, int node, int x, int y) {
		int mid = (x + y) >> 1;
		if (x == y) return x;
		if (TREE[node * 2] >= val) return query(val, node * 2, x, mid);
		return query(val - TREE[node * 2], node * 2 + 1, mid + 1, y);
	}
}