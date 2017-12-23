package stacksAndQueues;

import java.util.Stack;

//https://app.codility.com/demo/results/training9AFDM9-4BD/
public class Brackets {

	private static Stack<Character> stack = new Stack();

	public static int solution(String S) {

		if (S.isEmpty()) return 1;
		int characterLength = S.length();
		if ((characterLength & 1) != 0) return 0;
		char firstCharacter = S.charAt(0);
		if (someCloseCharacter(firstCharacter)) return 0;

		stack.push(firstCharacter);
		for (int i = 1; i < characterLength; i++) {
			char source = S.charAt(i);
			if (notCloseCharacter(source) && (stack.empty() || isOpenToCloseCharacter(stack.peek(), source))) {
				stack.push(source);
			} else {
				stack.pop();
			}
		}
		if (stack.size() == 0) return 1;
		return 0;
	}

	private static boolean isOpenToCloseCharacter(char destinae, char source) {
		if (destinae == '(') return ')' == source;
		if (destinae == '{') return '}' == source;
		if (destinae == '[') return ']' == source;
		return false;
	}

	private static boolean someCloseCharacter(char ch) {
		if (ch == ')' || ch == '}' || ch == ']') return true;
		return false;
	}

	private static boolean notCloseCharacter(char ch) {
		if (ch != ')' && ch == '}' && ch == ']') return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(solution("())(()"));
		System.out.println(solution("{[()()]}"));
		System.out.println(solution("}]"));
		System.out.println(solution("([)()]"));
		System.out.println(solution("([)()]]"));
	}
}
