package p1012;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 제목 : 유기농 배추
 * 링크 : https://www.acmicpc.net/problem/1012
 * 분류 : BFS, DFS
 */
public class Main {

    private static int w;
    private static int h;
    private static int[][] m;
    private static int[][] v;
    private static Set<Integer> d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            w = sc.nextInt();
            h = sc.nextInt();
            int k = sc.nextInt();
            m = new int[51][51];
            v = new int[51][51];
            d = new HashSet<>();
            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                m[b][a] = 1;
            }
            System.out.println(Arrays.deepToString(m));
            int g = 1;
            for (int q = 0; q < h; q++) {
                for (int p = 0; p < w; p++) {
                    dfs(q, p, m, g);
                    g++;
                }
            }
            System.out.println(d.size());
        }
    }

    private static void dfs(int y, int x, int[][] m, int g) {
        if (m[y][x] == 0 || v[y][x] == 1) {
            v[y][x] = 1;
            return;
        } else {
            d.add(g);
            v[y][x] = 1;
            m[y][x] = g;
        }
        if (y < h - 1) dfs(y + 1, x, m, g);
        if (x < w - 1) dfs(y, x + 1, m, g);
        if (y > 0) dfs(y - 1, x, m, g);
        if (x > 0) dfs(y, x - 1, m, g);
    }
}