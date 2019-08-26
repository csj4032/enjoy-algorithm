package p1992;

import java.util.Scanner;

public class Main {

    static int n;
    static char[][] m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                m[i][j] = line.charAt(j);
            }
        }
        System.out.println(quad(0, 0, n));
    }

    private static String quad(int x, int y, int n) {
        if (n == 1) {
            return String.valueOf(m[x][y]);
        }
        String a = quad(x, y, n / 2);
        String b = quad(x, y + (n / 2), n / 2);
        String c = quad(x + (n / 2), y, n / 2);
        String d = quad(x + (n / 2), y + (n / 2), n / 2);

        if (a.length() == 1 && a.equals(b) && a.equals(c) && a.equals(d)) {
            return a;
        } else {
            return "(" + a + b + c + d + ")";
        }
    }
}