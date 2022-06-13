package levelTwo;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NewsClustering {

	static Pattern pattern = Pattern.compile("[a-z,A-Z]{2}");

	public int solution(String str1, String str2) {
		List<String> str11 = extractString(str1);
		List<String> str22 = extractString(str2);

		if (str11.isEmpty() || str22.isEmpty()) {
			return 65536;
		}

		Map<String, Long> map11 = str11.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<String, Long> map22 = str22.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Sub> sub11 = map11.entrySet().stream().map(e -> new Sub(e.getKey(), e.getValue())).collect(Collectors.toList());
		List<Sub> sub22 = map22.entrySet().stream().map(e -> new Sub(e.getKey(), e.getValue())).collect(Collectors.toList());
		List<Sub> sub33 = new ArrayList<>(sub11);
		List<Sub> sub44 = new ArrayList<>(sub22);

		sub11.addAll(sub22);
		sub33.retainAll(sub44);

		List<Sub> sub55 = new ArrayList<>(sub11);
		List<Sub> sub66 = new ArrayList<>(sub33);

		System.out.println(sub55);
		System.out.println(sub66);

		Map<String, Optional<Sub>> union = sub55.stream().collect(Collectors.groupingBy(e -> e.getKey(), Collectors.maxBy(Sub::compareTo)));
		Map<String, Optional<Sub>> intersection = sub66.stream().collect(Collectors.groupingBy(e -> e.getKey(), Collectors.minBy(Sub::compareTo)));

		Long unionCount = union.entrySet().stream().mapToLong(e -> e.getValue().get().getCount()).sum();
		Long intersectionCount = intersection.entrySet().stream().mapToLong(e -> e.getValue().get().getCount()).sum();
		double temp = (double) intersectionCount / (double) unionCount;
		int answer = (int) (65536 * temp);
		return answer;
	}

	private List<String> extractString(String str2) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < str2.length(); i++) {
			if (i + 2 > str2.length()) break;
			String ss = str2.substring(i, i + 2).toLowerCase();
			Matcher matcher = pattern.matcher(ss);
			if (matcher.matches()) {
				result.add(ss);
			}
		}
		return result;
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