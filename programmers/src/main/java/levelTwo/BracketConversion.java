package levelTwo;

import java.util.Stack;

public class BracketConversion {

	public String solution(String p) {
		String answer = recursive(p);
		return answer;
	}

	private String recursive(String p) {
		if (p.equals("")) return "";
		String[] uv = balanced(p);
		String u = uv[0];
		String v = uv[1];
		if (correct(u)) {
			return u + recursive(v);
		} else {
			u = u.substring(1, u.length() - 1);
			String[] uu = u.split("");
			String uuu = "";
			for (int i = 0; i < u.length(); i++) {
				if (uu[i].equals("(")) {
					uuu += ")";
				} else {
					uuu += "(";
				}
			}
			return "(" + recursive(v) + ")" + uuu;
		}
	}

	private boolean correct(String u) {
		String[] brackets = u.split("");
		if (brackets[0].equals(")")) return false;
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < brackets.length; i++) {
			if (brackets[i].equals("(")) {
				stack.push(brackets[i]);
			} else {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public String[] balanced(String w) {
		Stack<String> stack = new Stack<>();
		String[] brackets = w.split("");
		stack.push(brackets[0]);
		int i = 1;
		while (!stack.isEmpty()) {
			if (stack.peek().equals(brackets[i])) {
				stack.push(brackets[i]);
			} else {
				stack.pop();
			}
			i++;
		}
		return new String[]{w.substring(0, i), w.substring(i)};
	}
}
