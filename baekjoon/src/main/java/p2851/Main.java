package p2851;

import java.util.Scanner;

/**
 * 제목 : 슈퍼 마리오
 * 링크 : https://www.acmicpc.net/problem/2851
 * 분류 : 구현
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] m = new int[10];
        int[] k = new int[1001];
        for (int i = 0; i < 10; i++) m[i] = sc.nextInt();

        int t = 0;
        for (int i = 0; i < 10; i++) {
            t += m[i];
            k[t] = 1;
            if(t > 100) break;
        }

        int a = 0;
        for (int i = 0; i <= 100; i++) {
            if (k[i] == 1) {
                a = i;
            }
        }

        int b = 0;
        for (int i = 101; i < 1001; i++) {
            if (k[i] == 1) {
                b = i;
            }
        }

        if (Math.abs(a - 100) >= Math.abs(b - 100)) {
            System.out.println(b);
        } else {
            System.out.println(a);
        }
    }
}