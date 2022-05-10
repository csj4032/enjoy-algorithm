package levelTwo;

import java.util.*;
import java.util.stream.Collectors;

public class Tuple {

	public int[] solution(String s) {
		String ss = s.replace("},", "|").replace("{", "").replace("}", "");
		String[] sss = ss.split("\\|");
		String[][] ssss = new String[sss.length][];
		HashMap<Integer, Integer> counts = new HashMap<>();

		for (int i = 0; i < sss.length; i++) {
			ssss[i] = sss[i].split("\\,");
		}

		for (int i = 0; i < ssss.length; i++) {
			String sssss[] = ssss[i];
			for (int j = 0; j < sssss.length; j++) {
				Integer key = Integer.parseInt(sssss[j]);
				if (counts.containsKey(key)) {
					counts.put(key, counts.get(key) + 1);
				} else {
					counts.put(key, 1);
				}
			}
		}

		int[] answer = counts.entrySet()
				.stream()
				.sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
				.keySet()
				.stream()
				.mapToInt(Integer::intValue)
				.toArray();
		return answer;
	}
}

class Count {
	String number;
	Integer count;

	public Count(String number, Integer count) {
		this.number = number;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Count{" +
				"number=" + number +
				", count=" + count +
				'}';
	}
}
