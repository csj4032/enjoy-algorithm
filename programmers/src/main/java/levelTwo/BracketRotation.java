package levelTwo;

import java.util.ArrayDeque;

public class BracketRotation {

	public int rotation(String s) {
		int count = 0;
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < s.length(); i++) {
			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
			if (bracket(sb.toString())) count++;
		}
		return count;
	}

	private boolean bracket(String s) {
		String[] ss = s.split("");
		int len = ss.length;
		ArrayDeque<String> queue = new ArrayDeque<>();
		if (ss[0].equals("]") | ss[0].equals("}") | ss[0].equals(")")) return false;
		if (ss[len - 1].equals("[") | ss[len - 1].equals("{") | ss[len - 1].equals("(")) return false;
		for (int i = 0; i < len; i++) {
			if (ss[i].equals("[") | ss[i].equals("{") | ss[i].equals("(")) {
				queue.addFirst(ss[i]);
			} else {
				if(queue.isEmpty()) return false;
				if (ss[i].equals("]") && queue.peek().equals("[")) {
					queue.poll();
				} else if (ss[i].equals("}") && queue.peek().equals("{")) {
					queue.poll();
				} else if (ss[i].equals(")") && queue.peek().equals("(")) {
					queue.poll();
				}
			}
		}

		if (queue.isEmpty()) return true;
		return false;
	}
}
