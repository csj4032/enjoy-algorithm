package futureTraining;

public class StrSymmetryPoint {

	public int solution(String s) {
		int length = s.length();
		if ((length & 1) == 0) return -1;
		int result = length / 2;
		for (int i = result, j = result; j >= 0; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return -1;
			}
		}
		return result;
	}
}