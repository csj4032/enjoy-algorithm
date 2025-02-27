package levelTwo;

import java.util.Arrays;

public class MazeEscape {

    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] dx = {-1, 1, 0, 0};
    private static int rows;
    private static int cols;
    private static int min;
    private static String[][] maze;
    private static boolean[][] visited;

    public int solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        min = Integer.MAX_VALUE;
        maze = new String[rows][cols];
        visited = new boolean[rows][cols];
        int[] start = new int[2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = String.valueOf(maps[i].charAt(j));
                if (maze[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        maze(start[0], start[1], 0, false);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void maze(int row, int col, int count, boolean lever) {
        if (maze[row][col].equals("E") && lever) {
            min = Math.min(min, count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = row + dy[i];
            int nx = col + dx[i];
            if (min < count) continue;
            if (nx < 0 || ny < 0 || ny >= rows || nx >= cols) continue;
            if (maze[ny][nx].equals("X") || visited[ny][nx]) continue;
            if (maze[ny][nx].equals("L")) {
                lever = true;
                for (int j = 0; j < visited.length; j++) {
                    Arrays.fill(visited[j], false);
                }
            }
            visited[ny][nx] = true;
            maze(ny, nx, count + 1, lever);
            visited[ny][nx] = false;
        }
    }
}
