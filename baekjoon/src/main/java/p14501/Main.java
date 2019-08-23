package p14501;

import java.util.Scanner;

/**
 * 제목 : 퇴사
 * 링크 : https://www.acmicpc.net/problem/14501
 * 분류 : 다이나믹 프로그래밍, 브루트 포스
 */
public class Main {

    private static int[] t;
    private static int[] p;
    private static int[] dp;
    private static int n;

    public static void main(String[] args) {
        init(new Scanner(System.in));
        System.out.println(force());
    }

    private static int force() {
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i - j >= t[j]) {
                    dp[i] = Math.max(dp[j] + p[i], dp[i]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i + t[i] <= n + 1) {
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    private static void init(Scanner sc) {
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
            dp[i] = p[i];
        }
    }
}
