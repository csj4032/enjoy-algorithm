package basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Algorithm3 {
	public static void main(String[] args) {
		//System.out.println(solution(new int[]{1, 4, -1, 3, 2}));
		//System.out.println(solution(new int[]{1, -1}));

//		solution2(new int[]{12345}, 10);
		//solution2(new int[]{4, 35, 80, 123, 12345, 44, 8, 5}, 10);
		//solution2(new int[]{4, 35, 80, 123, 12345, 44, 8, 5, 24, 3, 22}, 4);
//
//		System.out.println(solution3("a0Ba"));
//		System.out.println(solution3("a0bb"));
//		System.out.println(solution3("a0bbC"));
//		System.out.println(solution3("a0bbC0AAAA"));

		System.out.println(Arrays.toString(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).filter(x -> Arrays.stream(new int[]{1, 2}).anyMatch(y -> x == y)).toArray()));

		Vector<String> vector = new Vector<>();
	}

	private static int solution(int[] A) {
		int index = 0, count = 0;
		do {
			index = A[index];
			count++;
		} while (index != -1);
		return count;
//		int idx = A[0];
//		int count = 1;
//		while (true) {
//			if (A[idx] == -1) {
//				count++;
//				return count;
//			} else {
//				count++;
//				idx = A[idx];
//			}
//		}
	}

	private static void solution2(int[] A, int K) {
		int space = String.valueOf(Arrays.stream(A).max().getAsInt()).length();
		int len = A.length;
		decoration(space, (K > len ? len : K));
		for (int i = 0; i < len; i++) {
			boolean next = (i + 1) % K == 0;
			boolean isLast = i == (len - 1);
			System.out.print(white(space, A[i]) + A[i] + ((next || isLast) ? "|" : ""));
			if (next) {
				System.out.println();
				decoration(space, K);
			}
		}
		if (len % K != 0) {
			System.out.println();
			decoration(space, (len) % K);
		}
	}

	private static String white(int space, int number) {
		StringBuffer sb = new StringBuffer();
		sb.append("|");
		for (int j = 0; j < space - String.valueOf(number).length(); j++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	private static void decoration(int space, int k) {
		StringBuffer sb = new StringBuffer("+");
		for (int i = 0; i < space; i++) {
			sb.append("-");
		}
		for (int i = 0; i < k; i++) {
			System.out.print(sb.toString());
		}
		System.out.println("+");
	}

	private static int solution3(String S) {
		//return Arrays.stream(S.split("[0-9]+")).filter(s -> s.matches(".*[A-Z].*")).max(Comparator.comparing(String::length)).map(String::length).orElse(-1);
		return Arrays.stream(S.split("[0-9]+"))
				.filter(s -> s.matches(".*[A-Z].*"))
				.map(String::length)
				.max(Comparator.comparing(Integer::valueOf))
				.orElse(-1);
	}
}