package p1987;

import java.util.Scanner;

public class Main {

    private static String[][] b;
    private static long m = 0;
    private static int r;
    private static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        b = new String[r][c];
        for (int i = 0; i < r; i++) {
            String l = sc.next();
            for (int j = 0; j < c; j++) {
                String[] s = l.split("");
                b[i] = s;
            }
        }
        horse(0, 0, 0, "");
        System.out.println(m);
    }

    private static void horse(int i, int j, long k, String s) {
        if (s.contains(b[i][j])) {
            m = Math.max(m, k);
            return;
        }
        s += b[i][j];
        if (i > 0) horse(i - 1, j, k + 1, s);
        if (j < c - 1) horse(i, j + 1, k + 1, s);
        if (i < r - 1) horse(i + 1, j, k + 1, s);
        if (j > 0) horse(i, j - 1, k + 1, s);
    }
}
