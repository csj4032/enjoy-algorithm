package prefixSums;

import java.util.Arrays;

import static java.util.Arrays.asList;

//http://reddeco.tistory.com/entry/GenomicRangeQuery
public class GenomicRangeQuery {

	private static int TYPE_SIZE = 4;

	public static int[] solution(String S, int[] P, int[] Q) {
		int N = S.length();

		int[][] impactArray = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = i; j < TYPE_SIZE; j++) {
				impactArray[i][j] = letterToInt(asList(S.substring(i, j + 1).split("")).stream().min(String::compareTo).get());
			}
		}

		int M = P.length;
		int[] result = new int[M];

		for (int i = 0; i < M; i++) {
			int start = P[i];
			int end = Q[i];
			result[i] = impactArray[start][end];
		}
		return result;
	}

	private static int letterToInt(String letter) {
		if (letter.equals("A")) return 1;
		if (letter.equals("C")) return 2;
		if (letter.equals("G")) return 3;
		if (letter.equals("T")) return 4;
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
	}
}
