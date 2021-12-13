package kakaoBlindRecuitment2018;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartGame {

	private Pattern setPattern = Pattern.compile("(\\d{1,2})(S|D|T)(\\*|#)?");
	private Pattern pointPattern = Pattern.compile("(\\d+)([S|D|T])(\\*|#)?");
	private Map<String, Integer> map = Map.of("S", 1, "D", 2, "T", 3);

	public int solution(String dartResult) {
		double total = 0;
		double[] setTotal = new double[3];
		int idx = 0;
		Matcher matcher = setPattern.matcher(dartResult);
		while (matcher.find()) {
			String group = matcher.group();
			Matcher pointMatcher = pointPattern.matcher(group);
			while (pointMatcher.find()) {
				int point = Integer.parseInt(pointMatcher.group(1));
				String bonus = pointMatcher.group(2);
				setTotal[idx] = Math.pow(point, map.get(bonus));
				String option = pointMatcher.group(3);
				if (option != null) {
					if (option.equals("#")) {
						setTotal[idx] = setTotal[idx] * -1;
					} else {
						if (idx > 0) setTotal[idx - 1] = setTotal[idx - 1] * 2;
						setTotal[idx] = setTotal[idx] * 2;
					}
				}
			}
			idx++;
		}
		for (double setPoint : setTotal) total += setPoint;
		int answer = (int) total;
		return answer;
	}

	public static void main(String[] args) {
		DartGame dartGame = new DartGame();
		System.out.println(dartGame.solution("1D2S3T*"));
	}
}
