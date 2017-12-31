package basic;

import java.util.Stack;

public class Solution {

	public static int solution(String S) {

		Stack<Character> opening = new Stack<>();
		Stack<Character> closing = new Stack<>();
		Stack<Character> bracket = new Stack<>();
		int length = S.length();
		int k = 0;

		for (int i = 0; i < length; i++) {
			Character ch  = S.charAt(i);
			if (S.charAt(i) == '(') {
				bracket.push(ch);
				opening.push(ch);
			} else {
				if (!bracket.empty()) {
					bracket.pop();
					k++;
				} else {
					closing.push(ch);
				}
			}
		}

		//if (closing.empty()) return bracket.size();
		//if (bracket.empty()) return closing.size();

		return k + closing.size();
	}

	public static void main(String[] args) {
		System.out.println(solution("(())"));
		System.out.println(solution("(())))("));
		System.out.println(solution("(())())(())"));
		System.out.println(solution("(("));
		System.out.println(solution("))"));
		System.out.println(solution("((()))"));
		System.out.println(solution(")(())("));
	}
}