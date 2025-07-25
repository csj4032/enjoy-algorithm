package p1463;

import java.util.Scanner;

/**
 * 제목 : 1로 만들기
 * 링크 : https://www.acmicpc.net/problem/1463
 * 분류 : 다이나믹 프로그래밍
 * 
 * 문제 해설:
 * - 정수 N을 1로 만드는 최소 연산 횟수를 구하는 문제
 * - 사용 가능한 연산:
 *   1) X가 3으로 나누어떨어지면 3으로 나누기
 *   2) X가 2로 나누어떨어지면 2로 나누기  
 *   3) 1 빼기
 * 
 * 현재 구현: 백트래킹을 이용한 완전탐색 (시간복잡도 높음)
 * 개선 방향: DP 배열을 사용하여 dp[i] = i를 1로 만드는 최소 연산 횟수
 * 점화식: dp[i] = min(dp[i/3], dp[i/2], dp[i-1]) + 1
 */
public class Main {

    static int k = 1000000000;  // 최소 연산 횟수를 저장할 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursive(n, 0);  // 백트래킹으로 모든 경우의 수 탐색
        System.out.println(k);
    }

    /**
     * 백트래킹을 이용한 완전탐색 함수
     * @param n 현재 숫자
     * @param m 현재까지의 연산 횟수
     */
    private static void recursive(int n, int m) {
        if (n == 1 && k > m) k = m;  // 1에 도달하면 최소값 갱신
        if (k <= m) return;  // 가지치기: 현재 연산 횟수가 최소값보다 크면 중단
        
        // 3가지 연산을 모두 시도해보기
        if (n % 3 == 0) recursive(n / 3, m + 1);  // 3으로 나누기
        if (n % 2 == 0) recursive(n / 2, m + 1);  // 2로 나누기
        recursive(n - 1, m + 1);  // 1 빼기
    }
}