import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

public class SimpleBalancedParentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		while (sc.hasNext()) {
			String[] i = sc.next().split("");
			balanced(i);
		}
	}

	private static void balanced(String[] i) {
		Stack<String> s = new Stack();
		for (int j = 0; j < i.length; j++) {
			if (s.empty()) {
				s.push(i[j]);
			} else {
				if (s.firstElement().equals(i[j])) {
					s.push(i[j]);
				} else {
					if(s.firstElement().equals("("))
					s.pop();
				}
			}
		}
		System.out.println(s.empty() ? "정상" : "비정상");
	}
}