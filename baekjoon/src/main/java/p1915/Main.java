package p1915;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int dp[][] = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] s = sc.next().split("");
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.parseInt(s[j]);
                if (dp[i][j] > 0 && i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max * max);
    }
}