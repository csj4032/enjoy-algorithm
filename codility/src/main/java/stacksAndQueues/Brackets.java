package stacksAndQueues;

import java.util.Stack;

//https://app.codility.com/demo/results/training9AFDM9-4BD/
public class Brackets {

	private static Stack<Character> stack = new Stack();

	public int solution(String S) {
		int N = S.length();
		if (S.isEmpty()) return 1;
		if ((N & 1) != 0) return 0;

		char first = S.charAt(0);
		if (first == ')' || first == '}' || first == ']') return 0;

		Stack<Character> stack = new Stack();
		stack.push(first);
		for (int i = 1; i < N; i++) {
			char ch = S.charAt(i);
			if (stack.empty() || closeCharacter(stack.peek()) != (ch)) {
				if (ch != ')' && ch != '}' && ch != ']')
					stack.push(S.charAt(i));
			} else {
				stack.pop();
			}
		}
		if (stack.size() == 0) return 1;
		return 0;
	}

	public char closeCharacter(char c) {
		if (c == '(') return ')';
		if (c == '{') return '}';
		if (c == '[') return ']';
		return c;
	}
}
