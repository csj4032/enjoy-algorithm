package p2997;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int k[] = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        k[0] = a;
        k[1] = b;
        k[2] = c;

        int p = Math.abs(a - b);
        int p1 = Math.abs(a - c);
        int p2 = Math.abs(b - c);

        int m = Math.min(p, Math.min(p1, p2));

        int t1 = 0;
        int t2 = 0;

        Arrays.sort(k);

        for (int i = 0; i < 3; i++) {
            int t = k[i] + m;
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                if (t == k[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                t1 = t;
                break;
            }
        }

        for (int i = 2; i >= 0; i--) {
            int t = k[i] - m;
            boolean flag = true;
            for (int j = 2; j >= 0; j--) {
                if (t == k[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                t2 = t;
                break;
            }
        }

        if (t1 == t2) {
            System.out.println(t1);
        } else {
            System.out.println(Math.min(Math.abs(t1),Math.abs(t2)));
        }
    }
}
