package p9252;

import java.util.*;

/**
 * 제목 : LCS 2
 * 링크 : https://www.acmicpc.net/problem/9252
 */
//      C  A  P  C  A  K
//  [0, 0, 0, 0, 0, 0, 0]
//A [0, 0, 1, 1, 1, 1, 1]
//C [0, 1, 1, 1, 2!, 2, 2]
//A [0, 1, 2, 2, 2, 3!, 3]
//Y [0, 1, 2, 2, 2, 3, 3]
//K [0, 1, 2, 2, 2, 3, 4!]
//P [0, 1, 2, 3, 3, 3, 4]
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.next().split("");
        String[] b = sc.next().split("");
        longestCommonSubsequence(a, b);
    }

    private static void longestCommonSubsequence(String[] str1, String[] str2) {
        int n = str1.length;
        int m = str2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) dp[i][0] = 0;
        for (int i = 0; i < m; i++) dp[0][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1[i - 1].equals(str2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int count = dp[n][m];
        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        int max = count;
        for (int i = n; i > 0; i--) {
            for (int j = m; j > 0; j--) {
                if (str1[i - 1].equals(str2[j - 1]) && dp[i][j] == max) {
                    sb.append(str1[i - 1]);
					max--;
					break;
                }
            }
        }
		System.out.println(sb.reverse());
    }
}