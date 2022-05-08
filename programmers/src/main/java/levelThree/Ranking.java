package levelThree;

import java.util.Arrays;

public class Ranking {

	public int solution(int n, int[][] results) {
		int answer = 0;
		int length = results.length;
		int[][] board = new int[n][n];
		for (int i = 0; i < length; i++) {
			board[results[i][0] - 1][results[i][1] - 1] = 1;
		}

		System.out.println(Arrays.deepToString(board));

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((board[i][k] == 1 & board[k][j] == 1)) {
						System.out.println(k + " " + i + " " + j);
						board[i][j] = 1;
					}
				}
			}
		}

		System.out.println(Arrays.deepToString(board));

		int[] answers = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					answers[i] += 1;
					answers[j] += 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (answers[i] == (n - 1)) answer++;
		}
		return answer;
	}
}