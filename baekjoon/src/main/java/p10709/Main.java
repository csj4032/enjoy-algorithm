package p10709;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 기상캐스터 링크 : https://www.acmicpc.net/problem/10709 분류 : 구현
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int h = sc.nextInt();
        int w = sc.nextInt();
        String[][] s = new String[h][w];
        int[][] t = new int[h][w];

        for (int i = 0; i < h; i++) {
            String[] l = sc.next().split("");
            for (int j = 0; j < w; j++) s[i][j] = l[j];
        }

        for (int i = 0; i < h; i++) {
            Arrays.fill(t[i], -1);
            for (int j = 0; j < w; j++) {
                if (s[i][j].equals("c")) t[i][j] = 0;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (t[i][j - 1] > -1 && t[i][j] != 0) t[i][j] = t[i][j - 1] + 1;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) sb.append(t[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
