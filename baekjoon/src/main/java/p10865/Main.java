package p10865;

import java.util.Scanner;

/**
 * 제목 : 친구 친구
 * 링크 : https://www.acmicpc.net/problem/10865
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l[] = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            l[q] += 1;
            l[p] += 1;
        }
        for (int i = 1; i < n + 1; i++) sb.append(l[i]).append("\n");
        System.out.println(sb.toString());
    }
}
