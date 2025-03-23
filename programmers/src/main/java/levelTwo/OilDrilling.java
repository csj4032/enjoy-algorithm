package levelTwo;

import java.util.*;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/250136
 * Category : DFS/BFS
 */
public class OilDrilling {

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(int[][] land) {
        int answer = 0;
        int col = land[0].length;
        int row = land.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[][] visited = new boolean[row][col];

        int flag = 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (land[i][j] != 1) continue;
                int count = drilling(land, i, j, visited, flag);
                map.put(flag, count);
                flag++;
            }
        }

        for (int i = 0; i < col; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < row; j++) {
                if (land[j][i] > 1) set.add(land[j][i]);
            }
            int sum = 0;
            for (Integer a : set) sum += map.get(a);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    private int drilling(int[][] land, int row, int col, boolean[][] visited, int flag) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        land[row][col] = flag;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            for (int[] direction : directions) {
                int dy = y + direction[0];
                int dx = x + direction[1];
                if (dy >= 0 && dy < land.length && dx >= 0 && dx < land[0].length && !visited[dy][dx] && land[dy][dx] == 1) {
                    land[dy][dx] = flag;
                    queue.offer(new int[]{dy, dx});
                    visited[dy][dx] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private void drilling_(int[][] land, int row, int col, boolean[][] visited) {
        for (int i = 0; i < directions.length; i++) {
            int nextRow = row + directions[i][1];
            int nextCol = col + directions[i][0];
            if (nextRow < 0 || nextRow >= land.length || nextCol < 0 || nextCol >= land[0].length || land[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                continue;
            }
            visited[nextRow][nextCol] = true;
            drilling_(land, nextRow, nextCol, visited);
        }
    }
}
