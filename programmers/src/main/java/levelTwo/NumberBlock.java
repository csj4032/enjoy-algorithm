package levelTwo;

import java.util.Arrays;

public class NumberBlock {

	public int[] solution(int begin, int end) {
		int length = 1_000_000_000;
		int[] array = new int[length + 1];
		for (int i = 1; i < end; i++) {
			for (int j = 2; j < end; j++) {
				int index = (i * j) - 1;
				if (index >= length) break;
				array[index] = i;
			}
		}

		int[] answer = Arrays.copyOfRange(array, begin-1, end);
		return answer;
	}
}
