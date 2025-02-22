package levelZero;

import java.util.Arrays;

public class TestBed {

    public int solution(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        System.out.println(Arrays.deepToString(dp));
        System.out.println();
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                System.out.println(s.charAt(i) + " " + s.charAt(j) + " " + i + " " + j + " len : " + len);
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2;
                        System.out.println("(" + (i + 1) + ", " + j + ")  (" + i + ", " + (j - 1) + ") eq = 2");
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                        System.out.println("(" + (i) + ", " + j + ")  (" + (i + 1) + ", " + (j - 1) + ") eq + 2");
                    }
                } else {
                    System.out.println("(" + (i + 1) + ", " + j + ")  (" + i + ", " + (j - 1) + ") ne");
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                System.out.println(Arrays.deepToString(dp));
                System.out.println();
            }
        }
        System.out.println();
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        int result = testBed.solution("abba");
        System.out.println("");
        System.out.println(result);
    }
}