package p1018;

import java.util.Scanner;

/**
 * 제목 : 체스판 다시 칠하기
 * 링크 : https://www.acmicpc.net/problem/1018
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(brute(n - 8, m - 8, initBoard(sc, n, m)));
    }

    private static char[][] initBoard(Scanner sc, int n, int m) {
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String l = sc.next();
            for (int j = 0; j < m; j++) {
                chars[i][j] = l.charAt(j);
            }
        }
        return chars;
    }

    private static int brute(int p, int q, char[][] chars) {
        int t = 10000000;
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= q; j++) {
                t = Math.min(force(i, j, chars), t);
            }
        }
        return t;
    }

    private static int force(int p, int q, char[][] chars) {
        int w = 0, b = 0;
        char[] wb = new char[]{'W', 'B'};
        for (int i = p; i < 8 + p; i++) {
            for (int j = q; j < 8 + q; j++) {
                if (wb[(i + j) % 2] == chars[i][j]) w++;
                if (wb[(i + j) % 2] != chars[i][j]) b++;
            }
        }
        return Math.min(w, b);
    }
}
