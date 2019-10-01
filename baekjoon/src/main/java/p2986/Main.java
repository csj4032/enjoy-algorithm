package p2986;

import java.util.Scanner;

/**
 * 제목 : 파스칼
 * 링크 : https://www.acmicpc.net/problem/2986
 * 분류 : 구현
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0;
        for (int i = n - 1; i > 0; i--) {
            c = c + 1;
            if (n % i == 0) break;
        }
        System.out.println(c);
    }
}
