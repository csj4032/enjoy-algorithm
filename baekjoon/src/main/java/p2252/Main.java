package p2252;

import java.util.*;

public class Main {

	private static boolean[] visitor;
	private static List<List<Integer>> k;
	private static List<Integer> o;
	private static int n;
	private static int m;
	private static int[] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		count = new int[n + 1];
		k = new ArrayList<>();
		o = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) k.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			k.get(a).add(b);
			o.add(a);
			count[b]++;
		}

		topologicalSort();
	}

	private static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();

		for (int o : o) {
			if (count[o] == 0) queue.add(o);
		}

		for (int i = 0; i < n; i++) {
			int v = queue.remove();
			System.out.print(v + " ");
			for (int t : k.get(v)) {
				count[t]--;
				if (count[t] == 0) queue.add(t);
			}
		}
	}
}
