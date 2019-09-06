package p5800;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 성적 통계
 * 링크 : https://www.acmicpc.net/problem/5800
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            Arrays.sort(m);
            int gap = 0;
            for (int j = 1; j < n; j++) gap = Math.max(gap, Math.abs(m[j - 1] - m[j]));
            sb.append("Class " + (i + 1));
            sb.append("\n");
            sb.append("Max " + m[n - 1] + ", Min " + m[0] + ", Largest gap " + gap);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}