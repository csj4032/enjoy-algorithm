package levelThree;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/67259">경주로 건설</a>
 * Category : DFS/BFS, DP
 */
public class RaceTrack {

    public static int[] dy = {1, 0, -1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static int[][][] dp;

    public int solution(int[][] board) {
        dp = new int[board.length][board.length][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        int answer = dfs(board, 0, 0, -1, 0);
        return answer;
    }

    public static int dfs(int[][] board, int sy, int sx, int dir, int cost) {
        if (sy == board.length - 1 && sx == board.length - 1) return cost;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int ny = sy + dy[i];
            int nx = sx + dx[i];
            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board.length && board[ny][nx] == 0) {
                int costToNext = (dir == i || dir == -1) ? cost + 100 : cost + 600;
                if (costToNext < dp[ny][nx][i]) {
                    dp[ny][nx][i] = costToNext;
                    minCost = Math.min(minCost, dfs(board, ny, nx, i, costToNext));
                }
            }
        }
        return minCost;
    }
}
