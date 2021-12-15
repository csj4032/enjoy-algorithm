package skillChecks;

import java.util.Arrays;

public class Sort {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int s = commands[i][0];
			int e = commands[i][1];
			int k = commands[i][2];
			int[] n = new int[e - s];
			n = Arrays.copyOfRange(array, s - 1, e);
			Arrays.sort(n);
			answer[i] = n[k - 1];
		}
		return answer;
	}
}
