package levelTwo;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/389480
 * Category : Dynamic Programming
 * Description : 모든 가능한 누적 흔적(a, b) 상태을 dp[i][a][b]로 표현하여, 각 상태에서 다음 상태로의 전이 가능성을 체크
 */
public class PerfectCrime {

    public int solution(int[][] info, int n, int m) {
        int length = info.length;
        boolean[][][] dp = new boolean[length+1][n][m];
        dp[0][0][0] = true;

        for (int i = 0; i < length; i++) {
            int a = info[i][0];
            int b = info[i][1];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (dp[i][j][k]) {
                        if (j + a < n) {
                            dp[i + 1][a + j][k] = true;
                        }
                        if (k + b < m) {
                            dp[i + 1][j][b + k] = true;
                        }
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[length][i][j]) {
                    answer = Math.min(answer, i);
                }
            }
        }
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }
}
