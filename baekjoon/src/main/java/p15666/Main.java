package p15666;

import java.util.Arrays;
import java.util.Scanner;

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
        SEQUENCE = new int[M];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            NUMBERS[i] = sc.nextInt();
        }

        Arrays.sort(NUMBERS);
        recursive(0, 0);
        System.out.println(sb.toString());
    }

    private static void recursive(int k, int d) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(SEQUENCE[i] + " ");
            }
            sb.append("\n");
            return;
        }
        boolean[] INDEXS = new boolean[10001];
        for (int i = d; i < N; i++) {
            if (!VISITORS[i] && !INDEXS[NUMBERS[i]]) {
                SEQUENCE[k] = NUMBERS[i];
                INDEXS[NUMBERS[i]] = true;
                recursive(k + 1, i);
                VISITORS[i] = false;
            }
        }
    }
}
