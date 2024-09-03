package p2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 1; i < 10; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j < 10; j++) {
                int n = Integer.parseInt(s[j - 1]);
                if (max <= n) {
                    max = n;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxRow + " " + maxCol);
    }
}