package woowaBrothers.p2017;

import java.util.Arrays;

public class Solution2 {

	public static void main(String[] args) {
		solution(new int[]{12345}, 10);
	}

	private static void solution(int[] A, int K) {
		int space = String.valueOf(Arrays.stream(A).max().getAsInt()).length();
		int len = A.length;
		decoration(space, (Math.min(K, len)));
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
        return "|" +
                " ".repeat(Math.max(0, space - String.valueOf(number).length()));
	}

	private static void decoration(int space, int k) {
		StringBuilder sb = new StringBuilder("+");
        sb.append("-".repeat(Math.max(0, space)));
		for (int i = 0; i < k; i++) {
			System.out.print(sb.toString());
		}
		System.out.println("+");
	}
}
