package p3035;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int zr = sc.nextInt();
        int zc = sc.nextInt();

        String[][] w = new String[r][c];
        for (int i = 0; i < r; i++) {
            w[i] = sc.next().split("");
        }

        for (int i = 0; i < r * zr; i++) {
            for (int j = 0; j < c * zc; j++) {
                sb.append(w[i / zr][j / zc]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
