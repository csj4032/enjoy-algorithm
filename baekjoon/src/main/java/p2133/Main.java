package p2133;

import java.util.Scanner;

/**
 * 백준 2133번: 타일 채우기 (Gold 4)
 * https://www.acmicpc.net/problem/2133
 * 
 * == 문제 분류 ==
 * 동적 계획법, 수학, 조합론
 * 
 * == 알고리즘 이론 ==
 * 1. 타일링 문제 (Tiling Problem)
 *    - 3×N 격자를 2×1 타일로 채우는 경우의 수
 *    - 홀수 N일 때는 불가능 (면적이 홀수)
 *    - 짝수 N일 때만 가능한 특수한 패턴
 * 
 * 2. 점화식의 수학적 유도
 *    - dp[0] = 1 (아무것도 채우지 않는 경우)
 *    - dp[2] = 3 (기본 패턴 3가지)
 *    - dp[n] = 4*dp[n-2] - dp[n-4] (n ≥ 4, 짝수)
 * 
 * 3. 수학적 배경
 *    - 선형 점화식의 특성 방정식
 *    - 중복 계산 제거를 위한 수식 변형
 *    - 조합론적 해석
 * 
 * == 핵심 아이디어 ==
 * 1. 새로운 패턴과 기존 패턴의 관계 분석
 * 2. 대칭성을 이용한 중복 제거
 * 3. 점화식: f(n) = 4*f(n-2) - f(n-4)
 * 
 * == 시간복잡도 ==
 * O(n) - 선형 점화식 계산
 * 
 * == 공간복잡도 ==
 * O(n) - DP 배열 저장
 * 
 * == 구현 최적화 기법 ==
 * 1. 점화식 미리 계산으로 O(1) 접근
 * 2. 홀수 인덱스는 0으로 초기화
 * 3. 수학적 공식 활용으로 코드 간소화
 * 
 * == 실무 응용 ==
 * - 패턴 인식 및 생성
 * - 타일링 설계 소프트웨어
 * - 조합 최적화 문제
 * 
 * == 관련 심화 문제 ==
 * - 백준 2292: 벌집
 * - 백준 1904: 01타일
 * - 백준 11726: 2×n 타일링
 * - 백준 2225: 합분해
 */
public class Main {

    static long[] dp = new long[31];

    static {
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 0;
        dp[4] = 11;
        dp[5] = 0;
        dp[6] = 41;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 6; i <= n; i += 2) dp[i] = 4 * dp[i - 2] - dp[i - 4];
        System.out.println(dp[n]);
    }
}
