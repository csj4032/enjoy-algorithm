package p1773;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] m = new int[c + 1];

        for (int i = 0; i < n; i++) {
            int k = 0;
            int t = sc.nextInt();
            while (true) {
                k += t;
                if (k > c) break;
                m[k] = 1;
            }
        }

        int s = 0;
        for (int i = 0; i < c + 1; i++) {
            if (m[i] == 1) s++;
        }

        System.out.println(s);
    }
}
