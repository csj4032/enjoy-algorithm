package p1780;

import java.util.Scanner;

public class Main {

    static int m[][];
    static int k[] = new int[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        paper(0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(k[i]);
        }
    }

    private static void paper(int i, int j, int n) {
        for (int l = 0; l < n; l) {
            for (int o = 0; o < n; o++) {

            }
        }
    }
}
