package p9465;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m[][] = new int[2][n];
            int dp[][] = new int[3][n + 2];

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    m[j][k] = sc.nextInt();
                }
            }

            for (int j = 2; j < n + 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[0][k] =dp[0][0];
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
    }
}
//50 10 100 20 40
//30 50 70 10 60

// 0    0    0   0   0     0    0
// 0    0    50  10   0   30   190
// 0    0    30  100  80   160  2
