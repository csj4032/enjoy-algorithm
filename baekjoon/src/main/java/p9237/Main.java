package p9237;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 제목 : 이장님 초대
 * 링크 : https://www.acmicpc.net/problem/9237
 * 분류 : 트리
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] m = new Integer[n];
        int[] k = new int[n];

        for (int i = 0; i < n; i++) m[i] = sc.nextInt();

        Arrays.sort(m, Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int t = i + 2;
            int l = m[i];
            for (int j = 0; j < l; j++) {
                t++;
            }
            k[i] = t;
        }
        Arrays.sort(k);
        System.out.println(k[k.length-1]);
    }
}
