package elevenStreet.test02;

import java.util.Arrays;

import static java.util.stream.Collectors.groupingBy;

public class Solution2 {

	private static final int LOVELY_COUNT = 3;

	public int solution(int A, int B) {
		int range = B - (A - 1);
		for (int i = A; i <= B; i++) {
			long lovely = Arrays.asList(String.valueOf(i).split("")).stream().collect(groupingBy(String::valueOf)).values().stream().filter(count -> count.size() >= LOVELY_COUNT ).count();
			if (0 < lovely) range--;
		}
		return range;
	}

	public static void main(String[] args) {
		Solution2 solution2 = new Solution2();
		System.out.println(solution2.solution(0, 100000));
	}
}