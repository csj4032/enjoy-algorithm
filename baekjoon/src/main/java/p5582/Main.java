package p5582;

import java.util.Scanner;

/**
 * 제목 : 공통 부분 문자열
 * 링크 : https://www.acmicpc.net/problem/5582
 * 분류 : 다이나믹 프로그래밍, 접미사 배열
//  A B R A C A D A B R A
//E 0 0 0 0 0 0 0 0 0 0 0
//C 0 0 0 0 1 0 0 0 0 0 0
//A 1 0 0 1 0 2 0 1 0 0 1
//D 0 0 0 0 0 0 3 0 0 0 0
//A 1 0 0 1 0 1 0 4 0 0 1
//D 0 0 0 0 0 0 2 0 0 0 0
//A 1 0 0 1 0 1 0 3 0 0 1
//B 0 1 0 0 0 0 0 0 4 0 0
//R 0 0 1 0 0 0 0 0 0 5 0
//B 0 1 0 0 0 0 0 0 1 0 0
//C 0 0 0 0 1 0 0 0 0 0 0
//R 0 0 0 0 0 0 0 0 0 1 0
//D 0 0 0 0 0 0 1 0 0 0 0
//A 1 0 0 1 0 1 0 2 0 0 1
//R 0 0 0 0 0 0 0 0 0 1 0
//A 1 0 0 1 0 1 0 1 0 0 2
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
        int[][] dp = new int[4001][4001];

        int max = 0;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == (b[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}