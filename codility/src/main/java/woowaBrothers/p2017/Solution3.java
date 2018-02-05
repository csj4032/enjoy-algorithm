package woowaBrothers.p2017;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {

	public static void main(String[] args) {
		System.out.println(solution("a0Ba"));
	}

	private static int solution(String S) {
		return Arrays.stream(S.split("[0-9]+"))
				.filter(s -> s.matches(".*[A-Z].*"))
				.map(String::length)
				.max(Comparator.comparing(Integer::valueOf))
				.orElse(-1);
	}
}
