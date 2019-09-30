package p2033;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = 10;
        while (n > p) {
            int x = n % p;
            if (x >= p / 2) {
                n = n + p - x;
            } else {
                n = n - x;
            }
            p = p * 10;
        }
        System.out.println(n);
    }
}
