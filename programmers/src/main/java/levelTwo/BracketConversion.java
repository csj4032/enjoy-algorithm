package levelTwo;

public class BracketConversion {

	public String solution(String p) {
		String answer = recursive(p);
		return answer;
	}

	private String recursive(String p) {
		if (p.equals("")) return "";
		String u = "";
		String v = "";
		int pp = 0;
		int qq = 0;
		int ss = 0;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == ')') pp++;
			if (p.charAt(i) == '(') qq++;
			if (pp == qq) {
				ss = i;
				break;
			}
		}

		u = p.substring(0, ss + 1);
		v = p.substring(ss + 1);
		if (u.charAt(0) == ')') {
			String uu = "";
			for (int i = 1; i < u.length() - 1; i++) {
				if (u.charAt(i) == ')') {
					uu += "(";
				} else {
					uu += ")";
				}
			}
			return "(" + recursive(uu) + ")" + recursive(v);
		} else {
			return u + recursive(v);
		}
	}
}
