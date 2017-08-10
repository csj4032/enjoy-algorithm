import java.util.*;
import java.util.stream.Collectors;

public class IceCreamFactory {

	static Map<Integer, List<Integer>> ice = new HashMap<>();

	static {
//		ice.put(0, Arrays.asList(-20, -15));
//		ice.put(1, Arrays.asList(-14, -5));
//		ice.put(2, Arrays.asList(-18, -13));
//		ice.put(3, Arrays.asList(-5, -3));

		ice.put(0, Arrays.asList(-30, -4));
		ice.put(1, Arrays.asList(-28, -25));
		ice.put(2, Arrays.asList(-30, -4));
		ice.put(3, Arrays.asList(-30, -4));
		ice.put(4, Arrays.asList(-30, -4));
		ice.put(5, Arrays.asList(-30, -4));
	}

	public static void main(String[] args) {
		List<Integer> visited = new ArrayList<>();
		List<List<Integer>> pair = new ArrayList<>();
		for (int i = 0; i < ice.size(); i++) {
			List<Integer> a = ice.get(i);
			for (int j = i; j < ice.size(); j++) {
				List<Integer> b = ice.get(j);
				List<Integer> flat = pair.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
				if (i != j) {
					if ((a.get(0) <= b.get(0) && a.get(1) >= b.get(0)) || (a.get(0) <= b.get(1) && a.get(1) >= b.get(1))) {
						if (!visited.contains(j) && !visited.contains(i)) {
							visited.add(j);
							pair.add(Arrays.asList(i, j));
						}
					}
				}
			}
			visited.add(i);
		}
		System.out.println(visited);
		System.out.println(pair);
		System.out.println(pair.size());
	}
}
