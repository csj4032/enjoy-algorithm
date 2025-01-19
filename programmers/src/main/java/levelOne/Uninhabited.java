package levelOne;

import java.util.ArrayList;
import java.util.List;

public class Uninhabited {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int rows;
    static int cols;
    static int sum;
    static boolean[][] visited;
    static int[][] map;

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        rows = maps.length;
        cols = maps[0].length();
        map = new int[rows][cols];
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = maps[i].charAt(j) == 'X' ? -1 : maps[i].charAt(j) - '0';
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] != -1 && !visited[i][j]) {
                    answer.add(dfs(i, j));
                }
            }
        }
        if (answer.isEmpty()) answer.add(-1);
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public int dfs(int row, int col) {
        int sum = map[row][col];
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + row;
            int nx = dx[i] + col;
            if (0 <= nx && nx < cols && 0 <= ny && ny < rows && map[ny][nx] != -1 && !visited[ny][nx]) {
                sum += dfs(ny, nx);
            }
        }
        return sum;
    }
}
