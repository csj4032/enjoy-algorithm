package kakaoBlindRecuitment2020;

import java.util.*;

public class StringZip {

	public int zip(String string) {
		int len = string.length();
		String[] strings = new String[len];
		for (int i = 0; i < len; i++) {
			StringBuffer sb = new StringBuffer();
			Map<String, Integer> flag = new HashMap<>();
			int unit = i + 1;
			for (int j = 0; j < len; j += unit) {
				String subset = getSubset(string, len, unit, j);
				if (flag.containsKey(subset)) {
					flag.put(subset, flag.get(subset) + 1);
				} else {
					if (!flag.isEmpty()) {
						concatenated(sb, flag);
						flag.clear();
					}
					flag.put(subset, 1);
				}
			}
			concatenated(sb, flag);
			strings[i] = sb.toString();
		}
		Arrays.sort(strings, Comparator.comparingInt(String::length));
		return strings[0].length();
	}

	private String getSubset(String string, int len, int unit, int j) {
		int beginIndex = j;
		int endIndex = j + unit;
		if (endIndex >= len) endIndex = len;
		String subset = string.substring(beginIndex, endIndex);
		return subset;
	}

	private void concatenated(StringBuffer sb, Map<String, Integer> flag) {
		Map.Entry<String, Integer> prev = flag.entrySet().stream().findFirst().get();
		String prevKey = prev.getKey();
		Integer prevCount = prev.getValue();
		if (prevCount > 1) {
			sb.append(prevCount + "" + prevKey);
		} else {
			sb.append(prevKey);
		}
	}
}
