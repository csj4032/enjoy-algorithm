package basic;

import java.util.Stack;

public class Solution {

	public static int solution(String S) {

		Stack<Character> strings = new Stack<>();
		int length = S.length();

		for (int i = 0; i < length; i++) {
			if (S.charAt(i) == ')') {
				strings.push(S.charAt(i));
			}
		}
		return strings.size();
	}

	public static void main(String[] args) {
		System.out.println(solution("(())"));
		System.out.println(solution("(())))("));
		System.out.println(solution("))"));
	}
}