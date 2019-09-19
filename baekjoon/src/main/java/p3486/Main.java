package p3486;

import java.util.Scanner;

/**
 * 제목 : Adding Reversed Numbers
 * 링크 : https://www.acmicpc.net/problem/3486
 * 분류 : 트리
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuilder a = new StringBuilder(sc.next());
            StringBuilder b = new StringBuilder(sc.next());
            StringBuilder c = a.reverse();
            StringBuilder d = b.reverse();
            int e = Integer.parseInt(c.toString());
            int f = Integer.parseInt(d.toString());
            sb.append(Integer.parseInt(new StringBuilder(String.valueOf(e + f)).reverse().toString())).append("\n");
        }
        System.out.println(sb.toString());
    }
}