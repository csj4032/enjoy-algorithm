package levelTwo;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NewsClustering {

	static Pattern pattern = Pattern.compile("[a-zA-Z]{2}");

	public int solution(String str1, String str2) {
		List<Sub> sub11 = extractString(str1);
		List<Sub> sub22 = extractString(str2);

		if (sub11.isEmpty() && sub22.isEmpty()) return 65536;

		sub11.addAll(sub22);

		Map<String, List<Sub>> sub33 = sub11.stream().collect(Collectors.groupingBy(e -> e.getKey(), Collectors.toList()));

		List<Sub> intersection = sub33.entrySet()
				.stream()
				.filter(e -> e.getValue().size() > 1)
				.map(e -> e.getValue().stream().min(Sub::compareTo).get())
				.collect(Collectors.toList());
		List<Sub> union = sub33.entrySet()
				.stream()
				.map(e -> e.getValue().stream().max(Sub::compareTo).get())
				.collect(Collectors.toList());

		Long unionCount = union.stream().mapToLong(e -> e.getCount()).sum();
		Long intersectionCount = intersection.stream().mapToLong(e -> e.getCount()).sum();

		double temp = (double) intersectionCount / (double) unionCount;
		int answer = (int) (65536 * temp);
		return answer;
	}

	private List<Sub> extractString(String str2) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < str2.length(); i++) {
			if (i + 2 > str2.length()) break;
			String ss = str2.substring(i, i + 2).toLowerCase();
			Matcher matcher = pattern.matcher(ss);
			if (matcher.matches()) {
				result.add(ss);
			}
		}
		return result
				.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().map(e -> new Sub(e.getKey(), e.getValue())).collect(Collectors.toList());
	}
}

class Sub implements Comparable<Sub> {
	private String key;
	private Long count;

	public Sub(String key, Long count) {
		this.key = key;
		this.count = count;
	}

	public String getKey() {
		return key;
	}

	public Long getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Sub{" +
				"key='" + key + '\'' +
				", count=" + count +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Sub sub = (Sub) o;
		return Objects.equals(key, sub.key);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public int compareTo(Sub o) {
		return this.getCount().compareTo(o.getCount());
	}
}