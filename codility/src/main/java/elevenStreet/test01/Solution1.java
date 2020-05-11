package elevenStreet.test01;

public class Solution1 {

	public int solution(int N) {
		if (N == 0) return 0;
		int T = solution(N - 1);
		return T + N > 17 ? 5 : T + N;
	}
}