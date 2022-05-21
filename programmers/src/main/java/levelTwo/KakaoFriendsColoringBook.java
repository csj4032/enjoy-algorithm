package levelTwo;

public class KakaoFriendsColoringBook {

	static int[] dx = new int[]{0, 1, 0, -1};
	static int[] dy = new int[]{-1, 0, 1, 0};

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && visited[i][j] == false) {
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(i, j, picture, visited, m, n));
				}
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private int dfs(int i, int j, int[][] picture, boolean[][] visited, int m, int n) {
		int t = 1;
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int ii = i + dy[k];
			int jj = j + dx[k];
			if (ii < 0 || jj < 0 || ii >= m || jj >= n) continue;
			if (picture[i][j] == picture[ii][jj] && visited[ii][jj] == false) {
				t += dfs(ii, jj, picture, visited, m, n);
			}
		}
		return t;
	}


	private void display(int m, int n, int[][] picture) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(picture[i][j] + " ");
			}
			System.out.println();
		}
	}
}
