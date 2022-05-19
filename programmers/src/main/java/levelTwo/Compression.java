package levelTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {

	public int[] solution(String msg) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> index = new HashMap<>();
		for (int i = 1; i < 27; i++) index.put(String.valueOf((char) (64 + i)), i);

		for (int i = 0; i < msg.length(); i++) {
			if (i == msg.length() - 1) {
				answer.add(index.get(String.valueOf(msg.charAt(i))));
				continue;
			}
			for (int j = msg.length(); j >= i; j--) {
				String subString = msg.substring(i, j);
				if (index.containsKey(subString)) {
					int value = index.size() + 1;
					i += subString.length() - 1;
					answer.add(index.get(subString));
					if (j == msg.length()) continue;
					index.put(subString + msg.charAt(j), value);
					break;
				}
			}
		}
		return answer.stream().mapToInt(e -> e.intValue()).toArray();
	}
}
