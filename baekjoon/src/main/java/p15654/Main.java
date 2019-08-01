package p15654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] NUMBERS;
    static int[] SEQUENCE;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        NUMBERS = new int[N];
        SEQUENCE = new int[M];
        for (int i = 0; i < N; i++) {
            NUMBERS[i] = sc.nextInt();
        }
        Arrays.sort(NUMBERS);
        sb = new StringBuilder();
        recursive(0, 0);
        System.out.print(sb.toString());
    }

    private static void recursive(int k, int d) {
        if (k >= M) {
            for (int i = 0; i < M; i++) {
                sb.append(SEQUENCE[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            SEQUENCE[k] = NUMBERS[i];
            recursive(k + 1, i);
        }
    }
}
