package levelZero;

public class ArrangingPattern {

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, d = 0, seed = 1;
        int total = n * n;
        while (seed <= total) {
            answer[r][c] = seed++;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            r = nr;
            c = nc;
        }
        return answer;
    }
}
