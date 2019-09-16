package p2661;

import java.util.Scanner;

public class Main {

    private static int[] nn;
    private static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        nn = new int[k];
        good(0, "");
    }

    private static void good(int n, String m) {
        if (n == k) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (promise(m + i)) ;
            good(n + 1, m + i);
        }
    }

    private static boolean promise(String m) {
        return true;
    }
}