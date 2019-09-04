package p2798;

import java.util.Scanner;

public class Main {

    private static int n;
    private static int m;
    private static int p;
    private static int[] k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = 0;
        k = new int[n];

        for (int i = 0; i < n; i++) k[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int o = j + 1; o < n; o++) {
                    //System.out.println(k[i] + " " + k[j] + " " + k[o]);
                    if (m >= (k[i] + k[j] + k[o]))
                        p = Math.max((k[i] + k[j] + k[o]), p);
                }
            }
        }
        System.out.println(p);
    }
}
