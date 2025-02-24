package levelThree;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64062">징검다리 건너기</a>
 * Category : 이진 탐색
 * Solution :
 */
public class CrossTheSteppingBridge {

	public int solution(int[] stones, int k) {
		int answer = 0;
		int start = 1;
		int end = 200000000;

		while (start < end) {
			int median = (start + end) / 2;
			int zero = 0;
			int zeroMax = 0;
			for (int stone : stones) {
				if ((stone - median) <= 0) {
					zero++;
					zeroMax = Math.max(zero, zeroMax);
				} else {
					zero = 0;
				}
			}
			if (zeroMax < k) {
				start = median + 1;
			} else {
				end = median;
			}
			answer = end;
		}
		return answer;
	}
}
