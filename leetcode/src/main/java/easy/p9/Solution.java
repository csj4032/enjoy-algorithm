package easy.p9;

public class Solution {

	public boolean isPalindrome(int x) {
		String[] str = String.valueOf(x).split("");
		int length = str.length;
		int begin = 0;
		int end = length - 1;
		while (begin <= end) {
			if (!str[begin].equals(str[end])) return false;
			begin++;
			end--;
		}
		return true;
	}
}
