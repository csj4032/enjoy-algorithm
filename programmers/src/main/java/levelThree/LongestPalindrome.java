package levelThree;

public class LongestPalindrome {

	public int solution(String s) {
		int answer = 0;
		int length = s.length();
		String[] ss = s.split("");
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= i; j++) {
				if (palindrome(j - 1, i - 1, ss)) {
					answer = Math.max(answer, i - j + 1);
				}
			}
		}
		return answer;
	}

	private static boolean palindrome(int from, int to, String[] str) {
		while (from < to) {
			if (!str[from++].equals(str[to--])) {
				return false;
			}
		}
		return true;
	}
}
