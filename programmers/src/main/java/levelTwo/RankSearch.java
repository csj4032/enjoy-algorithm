package levelTwo;

import java.util.Arrays;

public class RankSearch {

	public int[] solution(String[] info, String[] query) {
		int m = info.length;
		int n = 5;
		String[][] table = new String[m][n];

		for (int i = 0; i < m; i++) table[i] = info[i].split(" ");

		int l = query.length;
		int[] answer = new int[l];
		String[][] queryTable = new String[l][n];

		for (int i = 0; i < l; i++) {
			String[] queries = query[i].split(" ");
			queryTable[i][0] = queries[0];
			queryTable[i][1] = queries[2];
			queryTable[i][2] = queries[4];
			queryTable[i][3] = queries[6];
			queryTable[i][4] = queries[7];
			String[] conditions = queryTable[i];
			boolean[][] checked = new boolean[m][n];
			for (int j = 0; j < 5; j++) {
				String condition = conditions[j];
				if (j == 4) {
					int condition1 = Integer.parseInt(conditions[4]);
					for (int jj = 0; jj < m; jj++) {
						int point = Integer.parseInt(table[jj][4]);
						if (condition1 <= point) checked[jj][4] = true;
						int kk = 0;
						for (int t = 0; t < n; t++) {
							if (checked[jj][t]) kk++;
						}
						if (kk == n) answer[i]++;
					}
				} else {
					for (int k = 0; k < m; k++) {
						if (table[k][j].equals(condition) || condition.equals("-")) {
							checked[k][j] = true;
						}
					}
				}
			}


			//System.out.println(Arrays.deepToString(checked));
		}
		//System.out.println(Arrays.toString(answer));
		return answer;
	}
}
