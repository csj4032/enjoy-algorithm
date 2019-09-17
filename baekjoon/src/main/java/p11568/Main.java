package p11568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] dp = new long[1000];
    static long[] nn = new long[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) nn[i] = Long.parseLong(st.nextToken());
        long max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nn[i] > nn[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(max);
    }
}
