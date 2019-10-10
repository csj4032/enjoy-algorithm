package p3054;

import java.util.Scanner;

public class Main {

    static String[][] p = new String[5][5];
    static String[][] q = new String[5][5];
    static String[][] t;
    static int l;

    static {
        p[0] = new String[]{".", ".", "#", ".", "."};
        p[1] = new String[]{".", "#", ".", "#", "."};
        p[2] = new String[]{"#", ".", " ", ".", "#"};
        p[3] = new String[]{".", "#", ".", "#", "."};
        p[4] = new String[]{".", ".", "#", ".", "."};

        q[0] = new String[]{".", ".", "*", ".", "."};
        q[1] = new String[]{".", "*", ".", "*", "."};
        q[2] = new String[]{"*", ".", " ", ".", "*"};
        q[3] = new String[]{".", "*", ".", "*", "."};
        q[4] = new String[]{".", ".", "*", ".", "."};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = sc.next();
        l = s.length();
        t = new String[5][l * 5];

        for (int i = 0; i < l; i++) {
            if ((i + 1) % 3 == 0) {
                merge(i, s.charAt(i), q);
            } else {
                merge(i, s.charAt(i), p);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 * l; j++) {
                if (t[i][j] != null) sb.append(t[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void merge(int idx, char c, String[][] s) {
        s[2][2] = String.valueOf(c);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (t[i][j + (5 * idx) - idx] == "*" && s[i][j] == "#") {
                    t[i][j + (5 * idx) - idx] = "*";
                } else {
                    t[i][j + (5 * idx) - idx] = s[i][j];
                }
            }
        }
    }
}