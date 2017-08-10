import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toList;

public class RightAngledTriangle {

	public static void main(String[] args) {
		final int n = 1001;
		final Map<Integer, Set<List<Integer>>> t = new ConcurrentHashMap<>();

		long start = new Date().getTime();

		for (int j = 1; j <= n; j++) {
			for (int k = 1; k <= n; k++) {
				for (int l = 1; l <= n; l++) {
					if ((j * j) + (k * k) == l * l && (j + k + l) <= n) {
						int sum = j + k + l;
						if (t.containsKey(sum)) {
							Set<List<Integer>> tt = t.get(sum);
							tt.add(Arrays.asList(new Integer[]{j, k, l}).stream().sorted().collect(toList()));
						} else {
							Set<List<Integer>> ttt = new HashSet<>();
							ttt.add(Arrays.asList(new Integer[]{j, k, l}).stream().sorted().collect(toList()));
							t.put(sum, ttt);
						}
					}
				}
			}
		}

		System.out.println(new Date().getTime() - start);
		System.out.println(t.keySet().stream().reduce((a, b) -> t.get(a).size() > t.get(b).size() ? a : b).get());
	}
}

//		IntStream.range(1, n + 1).parallel().forEach(j -> {
//			IntStream.range(1, n + 1).parallel().forEach(k -> {
//				IntStream.range(1, n + 1).parallel().forEach(l -> {
//					if ((j * j) + (k * k) == l * l && (j + k + l) <= n) {
//						int sum = j + k + l;
//						if (t.containsKey(sum)) {
//							Set<List<Integer>> tt = t.get(sum);
//							tt.add(Arrays.asList(new Integer[]{j, k, l}).stream().sorted().collect(Collectors.toList()));
//						} else {
//							Set<List<Integer>> ttt = new HashSet<>();
//							ttt.add(Arrays.asList(new Integer[]{j, k, l}).stream().sorted().collect(Collectors.toList()));
//							t.put(sum, ttt);
//						}
//					}
//				});
//			});
//		});