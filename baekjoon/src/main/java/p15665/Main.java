package p15665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] NUMBERS;
    static int[] SEQUENCE;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        NUMBERS = new int[N];
        SEQUENCE = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine().trim(), " ");

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            NUMBERS[i] = t;
        }

        Arrays.sort(NUMBERS);
        recursive(0);
        System.out.println(sb.toString());
    }

    private static void recursive(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(SEQUENCE[i] + " ");
            }
            sb.append("\n");
            return;
        }
        boolean[] INDEXS = new boolean[10001];
        for (int i = 0; i < N; i++) {
            if (!INDEXS[NUMBERS[i]]) {
                SEQUENCE[k] = NUMBERS[i];
                INDEXS[NUMBERS[i]] = true;
                recursive(k + 1);
            }
        }
    }
}
