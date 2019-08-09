package p15663;

import java.util.Arrays;
import java.util.Scanner;

// 15663번 : N과 M
public class Main {

    static int N;
    static int M;
    static boolean[] VISITORS;
    static int[] NUMBERS;
    static int[] SEQUENCE;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        VISITORS = new boolean[N];
        NUMBERS = new int[N];
        for (int i = 0; i < N; i++) {
            NUMBERS[i] = sc.nextInt();
        }
        Arrays.sort(NUMBERS);
        SEQUENCE = new int[N];
        recursive(0);
    }

    private static void recursive(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(SEQUENCE[i] + " ");
            }
            System.out.print("\n");
            return;
        }
        boolean check[] = new boolean[10001];
        for (int i = 0; i < N; i++) {
            if (!VISITORS[i] && !check[NUMBERS[i]]) {
                VISITORS[i] = true;
                check[NUMBERS[i]] = true;
                SEQUENCE[k] = NUMBERS[i];
                recursive(k + 1);
                VISITORS[i] = false;
            }
        }
    }
}