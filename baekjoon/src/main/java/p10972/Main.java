package p10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제목 : 다음 순열
 * 링크 : https://www.acmicpc.net/problem/10972
 */
public class Main {

    private static int[] m;
    private static int[] x;
    private static int[] a;
    private static int n;
    private static boolean f;
    private static boolean[] v;
    private static int c;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = new int[n];
        m = new int[n];
        a = new int[n];
        v = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            m[i] = n - i;
        }

        int i = n - 1;
        while (i > 0 && x[i - 1] >= x[i]) {
            i--;
        }
        if (i <= 0) System.out.println("-1");


    }

    private static void recursive(int d) {
        if (d == n) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!v[i - 1]) {
                v[i - 1] = true;
                a[d] = x[i - 1];
                recursive(d + 1);
                v[i - 1] = false;
            }
        }
    }

    private static void permutation(int d, int l, int t, int[] a) {
        if (d == t) {
            System.out.println(Arrays.toString(a));
            return;
        }

        for (int i = d; i < l; i++) {
            swap(i, d, a);
            permutation(d + 1, l, t, a);
            swap(i, d, a);
        }
    }

    private static void swap(int p, int q, int[] a) {
        a[p] = (a[p] + a[q]) - (a[q] = a[p]);
    }
}
