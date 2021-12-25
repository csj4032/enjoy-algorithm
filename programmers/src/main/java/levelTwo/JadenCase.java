package levelTwo;

public class JadenCase {

	public String convert(String s) {
		String[] ss = s.split("\\s");
		if (ss.length == 0) return s;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ss.length; i++) {
			if (ss[i].length() <= 0) {
				sb.append(" ");
			} else {
				sb.append(ss[i].substring(0, 1).toUpperCase() + ss[i].substring(1).toLowerCase());
				if (i < ss.length - 1) sb.append(" ");
			}
		}
		int white = s.length() - sb.length();
		for (int i = 0; i < white; i++) sb.append(" ");
		return sb.toString();
	}
}
