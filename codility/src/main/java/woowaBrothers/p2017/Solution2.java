package woowaBrothers.p2017;

import java.util.Arrays;

public class Solution2 {

	public static void main(String[] args) {
		solution(new int[]{12345}, 10);
	}

	private static void solution(int[] A, int K) {
		int space = String.valueOf(Arrays.stream(A).max().getAsInt()).length();
		int len = A.length;
		decoration(space, (K > len ? len : K));
		for (int i = 0; i < len; i++) {
			boolean next = ((i + 1) % K) == 0;
			boolean isLast = (i == (len - 1));
			System.out.print(white(space, A[i]) + A[i] + ((next || isLast) ? "|" : ""));
			if (next) {
				System.out.println();
				decoration(space, K);
			}
		}
		if ((len & K) == 0) {
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
}
