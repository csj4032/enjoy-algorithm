package p6131;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[501];
        int k = 0;

        for (int i = 1; i < 501; i++) {
            m[i] = (int) Math.pow(i, 2);
        }

        for (int i = 1; i < 501; i++) {
            for (int j = i; j < 501; j++) {
                if (n == Math.abs(m[i] - m[j])) {
                    k++;
                }
            }
        }
        System.out.println(k);
    }
}
