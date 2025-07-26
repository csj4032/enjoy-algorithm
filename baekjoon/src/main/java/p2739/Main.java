/**
 * 백준 2739번: 구구단
 * https://www.acmicpc.net/problem/2739
 * 
 * 문제 설명:
 * N이 주어졌을 때, N단을 출력하는 문제
 * N × 1부터 N × 9까지 출력
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 반복문 (for문)
 * - 곱셈 연산
 * - 문자열 출력 포맷
 * - 구구단의 개념
 * 
 * 시간복잡도: O(1) - 항상 9번 반복
 */
package p2739;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 구구단의 단수 입력
        
        // N단 출력 (1부터 9까지)
        for (int i = 1; i <= 9; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }
}