package p1436;

import java.util.Scanner;

/**
 * 제목 : 영화감독 숌
 * 링크 : https://www.acmicpc.net/problem/1436
 * 분류 : 탐색
 */
public class Main {

    private static int[] a = new int[10001];
    private static int s = 666;
    private static int i = 1;

    static {
        while (true) {
            if (String.valueOf(s).contains("666")) {
                a[i] = s;
                i++;
            }
            if (i == 10001) break;
            s++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(a[n]);
    }
}