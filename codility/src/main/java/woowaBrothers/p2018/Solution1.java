package woowaBrothers.p2018;

public class Solution1 {

	public static void main(String[] args) {
		System.out.println(solution("011100"));
		System.out.println(solution("011110"));
	}

	private static int solution(String S) {
		int n = Integer.parseInt(S, 2);
		int k = 0;
		while (n > 0) {
			if ((n & 1) == 0) {
				n = n / 2;
			} else {
				n = n - 1;
			}
			k++;
		}
		return k;
	}
}
