package levelThree;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12904">...</a>
 * Category : Dynamic Programming, DP, 다이나믹 프로그래밍
 */
public class LongestPalindrome {

    public int solution(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) dp[i][i] = 1;
        for (int len = 2; len <= length; len++) {
            for (int j = 0; j <= length - len; j++) {
                int k = len + j - 1;
                if (s.charAt(j) == s.charAt(k)) {
                    if (len == 2) {
                        dp[j][k] = 2;
                    } else {
                        dp[j][k] = dp[j + 1][k - 1] + 2;
                    }
                } else {
                    dp[j][k] = Math.max(dp[j + 1][k], dp[j][k - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
