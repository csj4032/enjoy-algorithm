package p1300;

import java.util.*;

/**
 * 제목 : K번째 수 - Binary Search on Answer
 * 링크 : https://www.acmicpc.net/problem/1300
 * 분류 : 이분탐색, 매개변수 탐색
 * 난이도 : Gold II
 * 
 * ========================================================================
 * ■ 문제 개요 및 핵심 개념
 * ========================================================================
 * 
 * N×N 배열 A[i][j] = i×j인 배열에서 모든 원소를 일차원 배열 B에 넣고 정렬했을 때,
 * B[k]의 값을 구하는 문제입니다.
 * 
 * ★ 핵심 아이디어:
 * - 직접 배열을 만들면 메모리 초과 (N ≤ 10^5이므로 10^10개 원소)
 * - 이분탐색으로 "K번째 수가 x일 때, x 이하인 수의 개수가 K개 이상인가?" 판단
 * - 각 행에서 x 이하인 수의 개수는 min(x/i, N)개
 * 
 * ★ 알고리즘:
 * 1) 이분탐색 범위: 1 ~ K (K번째 수는 최대 K)
 * 2) mid 값에 대해 mid 이하인 수의 개수를 계산
 * 3) 개수가 K 이상이면 더 작은 값도 가능하므로 right = mid
 * 4) 개수가 K 미만이면 더 큰 값이 필요하므로 left = mid + 1
 * 
 * 시간복잡도: O(N × log K)
 * 공간복잡도: O(1)
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        long left = 1;
        long right = K; // K번째 수는 최대 K
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long count = countLessOrEqual(N, mid);
            
            if (count >= K) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
    
    /**
     * N×N 배열에서 value 이하인 수의 개수를 계산
     */
    private static long countLessOrEqual(int N, long value) {
        long count = 0;
        
        for (int i = 1; i <= N; i++) {
            // i번째 행에서 value 이하인 수의 개수는 min(value/i, N)
            count += Math.min(value / i, N);
        }
        
        return count;
    }
}