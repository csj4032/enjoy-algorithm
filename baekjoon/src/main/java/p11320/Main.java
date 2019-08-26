package p11320;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double k = Math.ceil(sc.nextDouble() / sc.nextDouble());
            System.out.println((int) Math.pow(k, 2));
        }
    }
}