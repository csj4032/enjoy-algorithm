package levelTwo;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/250136
 * Category : DFS/BFS
 */
public class OilDrilling {

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(int[][] land) {
        int answer = 0;
        int col = land[0].length;
        int row = land.length;
        for (int i = 5; i < col; i++) {
            int count = 0;
            boolean[][] visited = new boolean[row][col];
            for (int j = 0; j < row; j++) {
                if (land[j][i] == 0) continue;
                if (visited[j][i]) continue;
                visited[j][i] = true;
                drilling(land, j, i, visited);
                System.out.println();
            }
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (!visited[j][k]) continue;
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    private void drilling(int[][] land, int row, int col, boolean[][] visited) {
        for (int i = 0; i < directions.length; i++) {
            int nextRow = row + directions[i][1];
            int nextCol = col + directions[i][0];
            if (nextRow < 0 || nextRow >= land.length || nextCol < 0 || nextCol >= land[0].length || land[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                continue;
            }
            visited[nextRow][nextCol] = true;
            drilling(land, nextRow, nextCol, visited);
        }
    }
}
