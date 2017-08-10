import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class SmallestRange {

	static int k = 3;
	static int maxSize;
	static List<List<Integer>> l0 = new ArrayList<>();

	static {
		l0.add(Arrays.asList(new Integer[]{4, 10, 15, 24, 26}));
		l0.add(Arrays.asList(new Integer[]{0, 9, 12, 20}));
		l0.add(Arrays.asList(new Integer[]{5, 18, 22, 30}));
		maxSize = l0.stream().sorted(Comparator.comparing(a -> a.size())).collect(toList()).get(l0.size() - 1).size();
	}

	static Integer[] t = new Integer[k];
	static Integer[] d = new Integer[maxSize];

	static List<List<Integer>> l1 = new ArrayList<>();
	static List<List<Integer>> l2 = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < maxSize; i++) {
			d[i] = i;
		}
		pwr(5, k);

		IntStream.range(0, l1.size()).forEach(i -> {
			List<Integer> ll = new ArrayList<>();
			IntStream.range(0, k).forEach(j -> {
				if (l0.get(j).size() > l1.get(i).get(j)) {
					ll.add(l0.get(j).get(l1.get(i).get(j)));
				}
			});
			l2.add(ll);
		});

		System.out.println(l2.stream().filter(i -> i.size() > 2).collect(toList()).stream().map(i -> {
			Integer a = i.stream().min(Integer::compareTo).orElse(Integer.MIN_VALUE);
			Integer b = i.stream().max(Integer::compareTo).orElse(Integer.MAX_VALUE);
			return b - a;
		}).min(Integer::compareTo).get());
	}

	private static void pwr(int n, int r) {
		if (r == 0) {
			l1.add(Arrays.asList(Arrays.copyOf(t, k)));
			return;
		}
		for (int i = n - 1; i >= 0; i--) {
			swap(i, n - 1, d);
			t[r - 1] = d[n - 1];
			pwr(n, r - 1);
			swap(i, n - 1, d);
		}
	}

	private static void swap(int i, int j, Integer[] d) {
		int t = d[i];
		d[i] = d[j];
		d[j] = t;
	}
}
