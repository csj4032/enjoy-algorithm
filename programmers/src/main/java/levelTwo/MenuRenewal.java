package levelTwo;

import java.util.*;
import java.util.stream.Collectors;

public class MenuRenewal {

	private static Map<String, Integer> menuMap = new LinkedHashMap<>();
	private static Map<Integer, Integer> maxMap = new LinkedHashMap<>();
	private static List<String> menus = new ArrayList<>();

	public String[] solution(String[] orders, int[] course) {
		for (int i = 0; i < orders.length; i++) {
			char[] menus = orders[i].toCharArray();
			int menuLength = menus.length;
			for (int j = 0; j < course.length; j++) {
				int courseLength = course[j];
				boolean[] visited = new boolean[menuLength];
				if (menuLength >= courseLength) {
					combination(menus, visited, 0, menuLength, courseLength);
				}
			}
		}

		menuMap.keySet().removeAll(menuMap.entrySet().stream().filter(e -> e.getValue().equals(1)).map(e -> e.getKey()).collect(Collectors.toList()));

		for (int i = 0; i < course.length; i++) {
			int key = course[i];
			Optional<Map.Entry<String, Integer>> value = menuMap.entrySet().stream().filter(e -> e.getKey().length() == key).max(Comparator.comparing(Map.Entry::getValue));
			if (value.isPresent()) {
				maxMap.put(key, value.get().getValue());
			}
		}
		for (Map.Entry<Integer, Integer> max : maxMap.entrySet()) {
			for (Map.Entry<String, Integer> menu : menuMap.entrySet()) {
				if (max.getKey() == menu.getKey().length() && max.getValue().equals(menu.getValue())) {
					menus.add(menu.getKey());
				}
			}
		}
		Collections.sort(menus);
		return menus.stream().toArray(String[]::new);
	}

	private void combination(char[] array, boolean[] visited, int from, int to, int depth) {
		if (depth == 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < from; i++) {
				if (visited[i]) sb.append(array[i]);
			}
			String[] menus = sb.toString().split("");
			Arrays.sort(menus);
			String key = Arrays.asList(menus).stream().collect(Collectors.joining());
			menuMap.computeIfPresent(key, (k, v) -> v + 1);
			menuMap.computeIfAbsent(key, (k) -> 1);
			return;
		}

		for (int i = from; i < to; i++) {
			visited[i] = true;
			combination(array, visited, i + 1, to, depth - 1);
			visited[i] = false;
		}
	}
}