package p1463;

import java.util.Scanner;

/**
 * 제목 : 1로 만들기
 * 링크 : https://www.acmicpc.net/problem/1463
 * 분류 : 다이나믹 프로그래밍
 */
public class Main2 {

    static int[] dp = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 1000001; i++) {
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[n]);
    }
}