package p9295;

import java.util.Scanner;

/**
 * 제목 : 주사위
 * 링크 : https://www.acmicpc.net/problem/9295
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append("Case " + (i + 1) + ": " + (a + b));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
