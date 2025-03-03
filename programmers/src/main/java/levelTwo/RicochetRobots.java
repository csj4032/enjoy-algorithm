package levelTwo;

import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobots {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public int solution(String[] board) {
        int answer = -1;
        int row = board.length;
        int col = board[0].length();
        int[][] map = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        int[] start = new int[2];
        for (int i = 0; i < board.length; i++) {
            String rows = board[i];
            for (int j = 0; j < rows.length(); j++) {
                if (rows.charAt(j) == 'R') start = new int[]{i, j};
                if (rows.charAt(j) == 'G') map[i][j] = 2;
                if (rows.charAt(j) == 'D') map[i][j] = 1;
            }
        }
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            int moves = current[2];

            if (map[cy][cx] == 2) return moves;

            for (int d = 0; d < 4; d++) {
                int nx = cx, ny = cy;
                while (nx >= 0 && nx < col && ny >= 0 && ny < row && map[ny][nx] != 1) {
                    nx += dx[d];
                    ny += dy[d];
                }
                if (!visited[ny - dy[d]][nx - dx[d]]) {
                    // System.out.println((ny - dy[d]) + " " + (nx - dx[d]) + " " + moves);
                    visited[ny - dy[d]][nx - dx[d]] = true;
                    queue.add(new int[]{ny - dy[d], nx - dx[d], moves + 1});
                }
            }
        }
        return answer;
    }
}
