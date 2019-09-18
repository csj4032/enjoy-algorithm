package p2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제목 : 신기한 소수
 * 링크 : https://www.acmicpc.net/problem/2023
 */
public class Main {

    static boolean[] map = new boolean[10];
    static {
        map[2] = true;
        map[3] = true;
        map[5] = true;
        map[7] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int from = 1;
        int to = 10;

        for (int i = 0; i < n - 1; i++) {
            from *= 10;
            to *= 10;
        }
        to -= 1;

        for (int i = from; i <= to; i++) {
            boolean f = true;
            int t = from;
            for (int j = 0; j < n; j++) {
                if (!isPrimeNumber(i / t)) {
                    f = false;
                    break;
                }
                t = t / 10;
            }
            if (f) System.out.println(i);
        }
    }

    private static boolean isPrimeNumber(int t) {
        if (t < 2) return false;
        if (t < 10 && !map[t]) return false;
        int p = (int) Math.sqrt(t);
        for (int i = 2; i <= p; i++) {
            if (t % i == 0) return false;
        }
        return true;
    }
}
