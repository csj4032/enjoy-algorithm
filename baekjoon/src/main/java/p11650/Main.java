package p11650;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static int m[] = new int[200001];
	static Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			m[x + 100000] = 1;
			if (map.get(x + 100000) == null) {
				List<Integer> list = new ArrayList<>();
				list.add(y);
				map.put(x + 100000, list);
			} else {
				map.get(x + 100000).add(y);
			}
		}

		map.keySet().stream().sorted().forEach(k -> {
			List list = map.get(k).stream().sorted().collect(Collectors.toList());
			list.stream().forEach(e -> {
				System.out.println(k-100000 + " " + e);
			});
		});
	}
}