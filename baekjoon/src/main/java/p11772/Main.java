package p11772;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = 0;
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = s / 10;
            int k = s % 10;
            m += (long) Math.pow(t, k);
        }
        System.out.println(m);
    }
}
