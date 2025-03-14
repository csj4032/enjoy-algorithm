package levelThree;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/67259">경주로 건설</a>
 * Category : DFS/BFS
 */
public class RaceTrack {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    private static int min;

    public int solution(int[][] board) {
        min = Integer.MAX_VALUE;
        dfs(board, new boolean[board.length][board.length], 0, 0, 0, 0);
        return min;
    }

    public void dfs(int[][] board, boolean[][] visited, int x, int y, int cost, int direction) {
        if (x == board.length - 1 && y == board.length - 1) {
            min = Math.min(min, cost - 500);
            return;
        }

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length || visited[ny][nx] || board[ny][nx] == 1) continue;
            cost = cost + 100;
            if (direction != i) cost = cost + 500;
            dfs(board, visited, nx, ny, cost, i);
        }
        visited[y][x] = false;
    }
}
