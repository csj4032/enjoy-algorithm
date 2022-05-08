package levelTwo;

import java.util.Stack;

public class PairToRemove {

	public int solution(String s) {
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack();

		for (int i = 0; i < chars.length; i++) {
			if (stack.isEmpty()) {
				stack.push(chars[i]);
			} else {
				if (stack.peek().equals(chars[i])) {
					stack.pop();
				} else {
					stack.push(chars[i]);
				}
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
}