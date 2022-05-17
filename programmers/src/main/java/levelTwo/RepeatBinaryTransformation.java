package levelTwo;

import java.util.Arrays;

public class RepeatBinaryTransformation {

	public int[] solution(String s) {
		int[] answer = new int[]{0, 0};
		while (true) {
			answer[0]++;
			String ss[] = s.split("");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < ss.length; i++) {
				if (ss[i].equals("0")) {
					answer[1]++;
					continue;
				}
				sb.append(ss[i]);
			}
			if (sb.toString().equals("1")) break;
			s = Integer.toBinaryString(sb.length());
		}
		return answer;
	}
}
