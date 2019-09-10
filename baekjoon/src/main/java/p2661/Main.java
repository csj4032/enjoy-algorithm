package p2661;

import java.util.Scanner;

public class Main {

    private static int[] nn;
    private static int k;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        k = sc.nextInt();
//        nn = new int[k];
//        good(0, "");
        System.out.println(promise("1212"));
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
        int len = m.length();
        int loop = m.length() / 2;
        int start = len - 1;
        int end = len;
        for (int i = 1; i <= loop; i++) {
            System.out.println(m.substring(start - i, end - i));
            System.out.println(m.substring(start, end));
            if (m.substring(start - i, end - i).equals(m.substring(start, end))) {
                return false;
            }
            start -= 1;
        }
        return true;
    }
}