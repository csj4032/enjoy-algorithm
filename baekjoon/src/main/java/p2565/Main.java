package p2565;

import java.util.Scanner;

public class Main {

    static int[] dp;
    static int[][] line;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[11];
        line = new int[n][2];

        for (int i = 0; i < n; i++) {
            line[i][0] = sc.nextInt();
            line[i][1] = sc.nextInt();
        }
    }
}
