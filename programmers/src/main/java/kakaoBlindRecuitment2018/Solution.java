package kakaoBlindRecuitment2018;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 제목 : 소수 찾기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42839
 * 분류 : 완전 탐색 (Exhaustive Search), 조합(nCr), 순열(nPr), DFS
 */
public class Solution {

	static String[] isNumbers;
	static String[] stringNumbers;
	static boolean[] isSelected;
	static int len = 0;
	static int cnt = 0;
	static Set<Integer> set = new HashSet<>();

	public int solution(String numbers) {
		len = numbers.length();
		stringNumbers = numbers.split("");
		for (int i = 0; i < len; i++) {
			isNumbers = new String[i + 1];
			isSelected = new boolean[len];
			perm(i + 1, 0);
		}
		for (Integer number : set) {
			if (isPrime(number)) {
				cnt++;
			}
		}
		return cnt;
	}

	private void perm(int limit, int depth) {
		if (depth == limit) {
			Integer number = Integer.valueOf(Stream.of(isNumbers).collect(Collectors.joining("")));
			System.out.println(number);
			set.add(number);
			return;
		}
		for (int i = 0; i < len; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			isNumbers[depth] = stringNumbers[i];
			perm(limit, depth + 1);
			isSelected[i] = false;
		}
	}

	private boolean isPrime(Integer number) {
		if (number < 2) return false;
		for (int i = 2; i <= (int) Math.sqrt(number); i++)
			if (number % i == 0) return false;
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("17"));
	}
}