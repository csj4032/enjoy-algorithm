package p15664;

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

        VISITORS = new boolean[10001];
        NUMBERS = new int[N];
        SEQUENCE = new int[M];
        for (int i = 0; i < N; i++) {
            NUMBERS[i] = sc.nextInt();
        }
        Arrays.sort(NUMBERS);
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
        boolean[] INDEXS = new boolean[10001];
        for (int i = 0; i < N; i++) {
            if (!VISITORS[i] && !INDEXS[NUMBERS[i]]) {
                SEQUENCE[k] = NUMBERS[i];
                //VISITORS[i] = true;
                INDEXS[NUMBERS[i]] = true;
                recursive(k + 1);
                VISITORS[i] = false;
            }
        }
    }
}
