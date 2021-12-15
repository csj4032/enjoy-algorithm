package skillChecks;

public class Push {

	public String solution(String s, int n) {
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			int k = s.charAt(i);
			int c = ' ';
			if (k >= 65 && k <= 90) {
				c = 65 + ((s.charAt(i) + n - 65) % 26);
			} else if (k >= 97 && k <= 122) {
				c = 97 + ((s.charAt(i) + n - 97) % 26);
			}
			answer += Character.toString((c));
		}
		return answer;
	}
}
