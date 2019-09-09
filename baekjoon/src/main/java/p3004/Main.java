package p3004;

import java.util.Scanner;

/**
 * 제목 : 체스판 조각
 * 링크 : https://www.acmicpc.net/problem/3004
 * 분류 : 반복문
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0) {
            System.out.println(((n / 2) + 1) * ((n / 2) + 1));
        } else {
            System.out.println((((n + 1) / 2) + 1) * ((n / 2) + 1));
        }
    }
}
