package p5555;

import java.util.Scanner;

/**
 * 제목 : 반지
 * 링크 : https://www.acmicpc.net/problem/5555
 * 분류 : 문자열 처리
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int n = sc.nextInt();
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (isContains(word, sc.next())) k++;
        }
        System.out.println(k);
    }

    private static boolean isContains(String word, String next) {
        String ringWord = next + next;
        return ringWord.contains(word);
    }
}