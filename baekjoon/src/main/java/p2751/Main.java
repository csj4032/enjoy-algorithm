package p2751;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] m = new Integer[1_000_001];
        Arrays.fill(m, 0);
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            m[k] = 1;
        }

        for (int i = 0; i < 1_000_001; i++) {
            if (m[i] == 1) {
                System.out.println(i);
            }
        }
    }
}