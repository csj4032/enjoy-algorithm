package levelTwo;

import java.util.LinkedList;
import java.util.Queue;

public class MazeEscape {

    private static final int[] dy = {0, 0, -1, 1};
    private static final int[] dx = {-1, 1, 0, 0};

    public int solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        char[][] maze = new char[rows][cols];
        int[] start = new int[2];
        int[] lever = new int[2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = maps[i].charAt(j);
                if (maze[i][j] == 'S') {
                    start = new int[]{i, j};
                } else if (maze[i][j] == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }

        int toLever = bfs(maze, start, 'L');
        if (toLever == -1) return -1;
        int toEnd = bfs(maze, lever, 'E');
        if (toEnd == -1) return -1;
        return toLever + toEnd;
    }

    public static int bfs(char[][] maze, int[] start, char target) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            int step = point[2];
            if (maze[row][col] == target) return step;
            for (int i = 0; i < 4; i++) {
                int ny = row + dy[i];
                int nx = col + dx[i];
                int nc = step + 1;
                if (nx < 0 || ny < 0 || ny >= rows || nx >= cols || maze[ny][nx] == 'X' || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx, nc});
            }
        }
        return -1;
    }
}
