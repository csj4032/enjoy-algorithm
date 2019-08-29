package p1463;

import java.util.Scanner;

/**
 * 제목 : 1로 만들기
 * 링크 : https://www.acmicpc.net/problem/1463
 * 분류 : 다이나믹 프로그래밍
 */
public class Main {

    static int k = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursive(n, 0);
        System.out.println(k);
    }

    private static void recursive(int n, int m) {
        if (n == 1 && k > m) k = m;
        if (k <= m) return;
        if (n % 3 == 0) recursive(n / 3, m + 1);
        if (n % 2 == 0) recursive(n / 2, m + 1);
        recursive(n - 1, m + 1);
    }
}