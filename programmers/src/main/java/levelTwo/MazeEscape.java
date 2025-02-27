package levelTwo;

import java.util.ArrayList;
import java.util.List;

public class MazeEscape {

    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] dx = {-1, 1, 0, 0};
    private static int min;

    public int solution(String[] maps) {
        min = Integer.MAX_VALUE;
        int rows = maps.length;
        int cols = maps[0].length();
        boolean[][] visited = new boolean[rows][cols];
        String[][] maze = new String[rows][cols];
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
//        System.out.println("start: " + start[0] + " " + start[1]);
        maze(start[0], start[1], 0, false, rows, cols, maze, visited);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void maze(int row, int col, int count, boolean lever, int rows, int cols, String[][] map, boolean[][] visited) {
        if (map[row][col].equals("E") && lever) {
//            System.out.println("row: " + row + " col: " + col + " count: " + count);
            min = Math.min(min, count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = row + dy[i];
            int nx = col + dx[i];
            if (nx < 0 || ny < 0 || ny >= rows || nx >= cols) continue;
            if (map[ny][nx].equals("X") || visited[ny][nx]) continue;
            if (map[ny][nx].equals("L")) lever = true;
            visited[ny][nx] = true;
            maze(ny, nx, count + 1, lever, rows, cols, map, visited);
            visited[ny][nx] = false;
        }
    }
}
