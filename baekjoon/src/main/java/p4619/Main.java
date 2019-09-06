package p4619;

import java.util.Scanner;

/**
 * 제목 : 루트 링크 : https://www.acmicpc.net/problem/4619
 */
public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int b = sc.nextInt();
            int n = sc.nextInt();

            if (b == 0 && n == 0) break;

            int a = 1;
            int t = 100000001;
            int r = 0;
            while (true) {
                int c = (int) Math.pow(a, n);
                int d = Math.abs(b - c);
                if (d < t) {
                    t = d;
                    r = a;
                }
                a++;
                if (b < c) break;
            }
            sb.append(r + "\n");
        }

        System.out.println(sb.toString());
    }
}
