package p1436;

import java.util.Scanner;

/**
 * 제목 : 영화감독 숌
 * 링크 : https://www.acmicpc.net/problem/1436
 * 분류 : 브루트포스 알고리즘, 탐색
 * 
 * 문제 해설:
 * - 영화 제목에 '666'이 포함된 수들을 '종말의 수'라 부름
 * - 666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, ...
 * - N번째 종말의 수를 구하는 문제
 * 
 * 해결 방법:
 * - 666부터 시작하여 순서대로 확인
 * - 각 수를 문자열로 변환하여 '666' 포함 여부 확인
 * - N번째를 찾을 때까지 반복
 * - 브루트포스 방식으로 완전탐색
 * 
 * 현재 구현:
 * - static 블록에서 미리 10000개의 종말의 수를 계산해두고 배열에 저장
 * - 연산 시간을 단축하여 빠른 응답 제공
 * 
 * 시간복잡도: O(1) - 미리 계산된 배열 접근
 * 공간복잡도: O(1) - 고정 크기 배열
 */
public class Main {

    private static int[] a = new int[10001];
    private static int s = 666;
    private static int i = 1;

    static {
        while (true) {
            if (String.valueOf(s).contains("666")) {
                a[i] = s;
                i++;
            }
            if (i == 10001) break;
            s++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(a[n]);
    }
}