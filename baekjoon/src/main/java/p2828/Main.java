package p2828;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 사과 담기 게임
 * 링크 : https://www.acmicpc.net/problem/2828
 * 분류 : 그리디 알고리즘, 반복문
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int j = sc.nextInt();
        boolean c[] = new boolean[n];
        int t1 = 0, t2 = m, k = 0;
        for (int i = 0; i < m; i++) c[i] = true;
        for (int i = 0; i < j; i++) {
            int p = sc.nextInt() - 1;
            while (true) {
                if (c[p]) break;
                k++;
                Arrays.fill(c, false);
                if (p > t1) {
                    ++t1;
                    ++t2;
                    for (int h = t1; h < t2; h++) c[h] = true;
                } else {
                    --t1;
                    --t2;
                    for (int h = t1; h < t2; h++) c[h] = true;
                }
            }
            sb.append("\n");
        }
        System.out.println(k);
    }
}
