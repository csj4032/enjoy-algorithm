package p5567;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 제목 : 결혼식
 * 링크 : https://www.acmicpc.net/problem/5567
 * 분류 : 구현
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] t = new int[501][501];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            t[a][b] = 1;
            t[b][a] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            int r = 0;
            if (t[1][i] == 1) {
                r = i;
                set.add(i);
            }
            for (int j = 2; j < n + 1; j++) {
                if (t[r][j] == 1) {
                    set.add(j);
                }
            }
        }

        System.out.println(set.size());
    }
}
