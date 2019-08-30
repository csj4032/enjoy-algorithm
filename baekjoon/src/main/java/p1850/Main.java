package p1850;

import java.util.Scanner;

/**
 * 제목 : 최대공약수
 * 링크 : https://www.acmicpc.net/problem/1850
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        StringBuilder sb = new StringBuilder();
        long k = gcd(n, m);
        for (int i = 0; i < k; i++) {
            sb.append("1");
        }
        System.out.println(sb.toString());
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
