package p5612;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            m = m + a - b;
            if (m < 0) {
                k = 0;
                break;
            }
            k = Math.max(k, m);

        }
        System.out.println(k);
    }
}
