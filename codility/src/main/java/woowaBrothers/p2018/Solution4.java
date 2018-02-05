package woowaBrothers.p2018;

public class Solution4 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 5));
		System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 2));
		System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 9));
		System.out.println(solution(new int[]{-1, -2, 5, 9, 10, 11, 12, 13, 14, 15}, -2));
		System.out.println(solution(new int[]{-1, -2, 5, 9, 10, 11, 12, 13, 14, 15}, -2));
	}

	private static int solution(int[] A, int X) {
		int N = A.length;
		if (N == 0) {
			return -1;
		}

		int l = 0;
		int r = N - 1;

		while (l < r) {
			int m = (l + r) / 2 + 1;
			if (A[m] > X) {
				r = m - 1;
			} else {
				l = m;
			}
		}

		if (A[l] == X) {
			return l;
		}

		return -1;
	}
}
