package p2875;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        if ((n + m) == k) {
            System.out.println(0);
        } else {
            int t = 0;
            while (true) {
                n = n - 2;
                m = m - 1;
                if (n < 0 || m < 0) {
                    n += 2;
                    m += 1;
                    break;
                }
                t++;
            }
            k = k - (n + m);
            if (k > 0) {
                k = (int) Math.ceil((double) k / 3);
            } else {
                k = 0;
            }
            System.out.println(t - k);
        }
    }
}
