package p5176;

import java.util.Scanner;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int[] s = new int[p];
            for (int j = 0; j < p; j++) s[j] = sc.nextInt();
            check(p, m, s);
        }
        System.out.println(sb.toString());
    }

    private static void check(int p, int m, int[] s) {
        boolean[] t = new boolean[m + 1];
        for (int i = 0; i < p; i++) {
            if (!t[s[i]]) t[s[i]] = true;
        }

        int q = 0;
        for (int i = 1; i < t.length; i++) {
            if (t[i]) q++;
        }
        sb.append(p-q + "\n");
    }
}
