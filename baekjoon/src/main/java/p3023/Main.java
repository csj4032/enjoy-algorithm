package p3023;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int r = sc.nextInt();
        int c = sc.nextInt();
        String[][] l = new String[r][c];
        String[][] k = new String[r * 2][c * 2];
        for (int i = 0; i < r; i++) {
            String[] t = sc.next().split("");
            for (int j = 0; j < c; j++) {
                l[i][j] = t[j];
            }
        }

        //System.out.println(Arrays.deepToString(l));

        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c * 2; j++) {
                if (j < c) {
                    k[i][j] = l[i][j];
                } else {
                    k[i][j] = l[i][2 * c - (j + 1)];
                }
            }
        }

       // System.out.println(Arrays.deepToString(k));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c * 2; j++) {
                k[r * 2 - (i + 1)][j] = k[i][j];
            }
        }

        for (int i = 1; i <= r * 2; i++) {
            for (int j = 1; j <= c * 2; j++) {
                if (a == i && b == j) {
                    sb.append(k[i - 1][j - 1].equals(".") ? "#" : ".");
                } else {
                    sb.append(k[i - 1][j - 1]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
