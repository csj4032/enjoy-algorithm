package p11066;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int testCase[] = new int[n];
            for (int j = 0; j < n; j++) testCase[j] = s.nextInt();
            System.out.println(solution(testCase));
        }
    }

    public static int sum(int[] a, int s, int e) {
        if (s == 0) return a[e];
        else return a[e] - a[s - 1];
    }

    private static int solution(int[] a) {
        int size = a.length;
        int DP[][] = new int[size][size];
        int s[] = new int[size];

        s[0] = a[0];
        for (int i = 1; i < size; i++) s[i] += s[i - 1] + a[i];

        for (int i = 0; i < size - 1; i++) DP[i][i + 1] = a[i] + a[i + 1];

        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.deepToString(DP));

        for (int gap = 2; gap < size; gap++) {
            for (int i = 0; i + gap < size; i++) {
                int j = i + gap;
                DP[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    DP[i][j] = Math.min(DP[i][k] + DP[k + 1][j] + sum(s, i, j), DP[i][j]);
                    System.out.println(Arrays.deepToString(DP) + " i = " + i + " j = " + j + " k = " + k + " sum = " + sum(s, i, j));
                }
            }
        }
        return DP[0][a.length - 1];
    }
}