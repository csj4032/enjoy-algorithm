package p2992;

import java.util.Scanner;

public class Main {

    static int min = Integer.MAX_VALUE;
    static String x;
    static int z;
    private static String[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.next();
        z = Integer.parseInt(x);
        arr = new String[x.length()];

        for (int i = 0; i < x.length(); i++) arr[i] = String.valueOf(x.charAt(i));

        permutation(0, arr.length, arr.length, arr);

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    private static void permutation(int d, int k, int s, String[] arr) {
        if (d == s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) sb.append(arr[i]);
            if (!x.equals(sb.toString())) {
                int t = Integer.parseInt(sb.toString());
                if (z < t) min = Math.min(min, t);
            }
            return;
        }

        for (int i = 0; i < k; i++) {
            swap(i, d, arr);
            permutation(d + 1, k, s, arr);
            swap(i, d, arr);
        }
    }

    private static void swap(int a, int b, String[] arr) {
        String t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
