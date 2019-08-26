package p11312;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        for (long i = 0; i < n; i++) {
            double k = Math.ceil(sc.nextDouble() / sc.nextDouble());
            System.out.println((long) Math.pow(k, 2));
        }
    }
}
