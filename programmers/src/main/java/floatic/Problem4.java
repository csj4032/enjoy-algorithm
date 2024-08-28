package floatic;

import java.util.*;


public class Problem4 {

    public static void main(String[] args) {
        // 입력 예시
        String[] grid = {"####", "##.#", ".#.#"};
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.solution(grid));
    }

    // 상하좌우 방향
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(String[] grid) {
        int answer = 0;
        int rows = grid.length;
        int cols = grid[0].length();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == '.' && !visited[i][j]) {
                    int[] result = dfs(grid, visited, i, j);
                    if (result[1] == 1) {
                        answer += result[0];
                    }
                }
                if (grid[i].charAt(j) == '#') answer++;
            }
        }
        return answer;
    }

    private int[] dfs(String[] grid, boolean[][] visited, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int area = 0;
        boolean isEnclosed = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int cx = cell[0];
            int cy = cell[1];
            area++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) {
                    isEnclosed = false;
                } else if (!visited[nx][ny]) {
                    if (grid[nx].charAt(ny) == '.') {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    } else if (grid[nx].charAt(ny) == '#') {
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return new int[]{area, isEnclosed ? 1 : 0};
    }
}


