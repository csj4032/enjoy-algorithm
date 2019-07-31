package p15651;

import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] NUMBERS;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        NUMBERS = new int[M];
        sb = new StringBuilder();
        recursive(0);
        System.out.print(sb.toString());
    }

    private static void recursive(int k) {
        if (k >= M) {
            for (int i = 0; i < M; i++) {
                sb.append(NUMBERS[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            NUMBERS[k] = i;
            recursive(k + 1);
        }
    }
}