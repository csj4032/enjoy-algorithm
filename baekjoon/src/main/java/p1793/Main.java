package p1793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 제목 : 타일링
 * 링크 : https://www.acmicpc.net/problem/1793
 * 분류 : 다이나믹 프로그래밍, 큰 수
 * 메모 : 전형적인 다이나믹 프로그래밍 문제 n 일때의 경우는 n-1의 경우 더하기 (n-2) * 2 의 경우
 */
public class Main {

    static BigInteger[] dp = new BigInteger[251];

    static {
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = new BigInteger("3");
        dp[3] = new BigInteger("5");
        dp[4] = new BigInteger("11");

        for (int i = 3; i < 251; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            sb.append(dp[n] + "\n");
        }

        System.out.println(sb.toString());
    }
}