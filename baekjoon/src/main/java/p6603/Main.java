package p6603;

import java.util.Scanner;

/**
 * 제목 : 로
 * 링크 : https://www.acmicpc.net/problem/6603
 * 메모 : BFS, 브루트 포스, DFS, 백트래킹, 입문용
 */
public class Main {

    private static StringBuilder sb;
    private static int k;
    private static String[] t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String number = sc.nextLine();
            if (number.equals("0")) break;
            lotto(number);
        }
        sc.close();
    }

    private static void lotto(String number) {
        String[] numbers = number.split(" ");
        k = Integer.valueOf(numbers[0]);
        t = new String[k];
        sb = new StringBuilder();
        System.arraycopy(numbers, 1, t, 0, k);
        recursive(0, 0, "");
        System.out.println(sb.toString());
    }

    private static void recursive(int d, int s, String str) {
        if (d == 6) {
            sb.append(str + "\n");
            return;
        }
        for (int i = s; i < k; i++) {
            recursive(d + 1, i + 1, str + t[i] + " ");
        }
    }
}