package p1188;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int g = gcd(n, m);
        System.out.println(m - g);
    }

    private static int gcd(int p, int q) {
        if (p % q == 0) return q;
        return gcd(q, p % q);
    }
}
