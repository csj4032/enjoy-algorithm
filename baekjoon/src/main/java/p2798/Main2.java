package p2798;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    private static int l = 3;
    private static int n;
    private static int[] k;
    private static boolean[] v;
    private static int[] t = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = new int[n];
        v = new boolean[n];

        for (int i = 0; i < n; i++) k[i] = sc.nextInt();

        black(0, 0);
    }

    private static void black(int i, int d) {
        if (d == l) {
            System.out.println(Arrays.toString(t));
            return;
        }
        for (int j = i; j < n; j++) {
            if (v[j]) continue;
            v[j] = true;
            t[d] = k[j];
            black(j, d + 1);
            v[j] = false;
        }
    }
}
