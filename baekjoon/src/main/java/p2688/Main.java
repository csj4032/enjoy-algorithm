package p2688;

import java.util.Scanner;

public class Main {

    static long[][] dp = new long[65][11];

    static {
        dp[0] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        dp[1] = new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        dp[2] = new long[]{0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55};
    }

    public static void main(String[] args) {
        for (int i = 3; i < 66; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sb.append(dp[n][10]).append("\n");
        }
        System.out.println(sb);
    }
}
