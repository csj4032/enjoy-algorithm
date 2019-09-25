package p5618;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        long[] m = new long[n];
        for (int i = 0; i < n; i++) m[i] = sc.nextLong();

        for (int i = 1; i <= m[0]; i++) {
            boolean c = true;
            for (int j = 0; j < n; j++) {
                if (m[j] % i != 0) {
                    c = false;
                    break;
                }
            }
            if (c) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
}
