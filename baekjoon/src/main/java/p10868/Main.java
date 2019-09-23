package p10868;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 최솟값
 * 링크 : https://www.acmicpc.net/problem/10868
 * 분류 : 세그먼트 트리
 */
public class Main {

    static final int max = 1000000007;
    static int[] tree;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        tree = new int[1 << ((int) Math.ceil(Math.log(n) / Math.log(2)) + 1)];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        segment(1, 0, n - 1);

        for (int i = 0; i < m; i++)
            sb.append(query(1, 0, n - 1, sc.nextInt() - 1, sc.nextInt() - 1)).append("\n");

        System.out.println(sb.toString());
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(tree));
    }

    private static int segment(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];
        int mid = (left + right) / 2;
        return tree[node] = Math.min(segment(node * 2, left, mid), segment(node * 2 + 1, mid + 1, right));
    }

    private static int query(int i, int left, int right, int start, int end) {
        if (right < start || end < left) return max;
        if (start <= left && right <= end) {
            return tree[i];
        }
        int mid = (left + right) / 2;
        return Math.min(query(i * 2, left, mid, start, end), query(i * 2 + 1, mid + 1, right, start, end));
    }
}
