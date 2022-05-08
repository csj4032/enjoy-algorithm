package levelTwo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TriangularSnail {

	public int[] solution(int n) {
		int length = IntStream.range(0, n).reduce(0, (a, b) -> a + b);
		int[] answer = new int[length];
		int number = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer[i] = number++;
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
