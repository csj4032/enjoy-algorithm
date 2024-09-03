package p11049;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[][] dp;
    static int[][] m;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        dp = new int[n + 1][n + 1];
        m = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            m[i][0] = sc.nextInt();
            m[i][1] = sc.nextInt();
        }

        System.out.println("g" + " i" + " j" + " k");
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    System.out.println(gap + " " + i + " " + j + " " + k);
                    int value = dp[i][k] + dp[k + 1][j] + (m[i][0] * m[k][1] * m[j][1]);
                    dp[i][j] = Math.min(dp[i][j], value);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}




