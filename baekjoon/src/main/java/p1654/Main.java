package p1654;

/*
 * 백준 1654번: 랜선 자르기
 * https://www.acmicpc.net/problem/1654
 * 
 * [문제 분류] 이분 탐색 (Binary Search) / 매개변수 탐색
 * [난이도] Silver 2
 * 
 * [문제 요약]
 * 오영식이 K개의 랜선을 가지고 있다. 그러나 K개의 랜선의 길이가 제각각이다.
 * 그는 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
 * 
 * [제약 조건]
 * - 1 ≤ K ≤ 10,000
 * - 1 ≤ N ≤ 1,000,000
 * - K ≤ N
 * - 1 ≤ 각 랜선의 길이 ≤ 2^31 - 1
 * 
 * [알고리즘 설명 - 매개변수 탐색]
 * 1. 핵심 아이디어: 랜선의 길이를 매개변수로 하여 이분 탐색
 * 2. 특정 길이로 잘랐을 때 N개 이상의 랜선을 만들 수 있는지 확인
 * 3. 가능한 최대 길이를 찾는 최적화 문제
 * 
 * [이분 탐색 범위 설정]
 * - left = 1 (최소 길이)
 * - right = max(랜선 길이들) (최대 길이)
 * - mid = (left + right) / 2
 * 
 * [판단 함수 (Decision Function)]
 * boolean canMake(int[] cables, int length, int target) {
 *     long count = 0;
 *     for (int cable : cables) {
 *         count += cable / length;
 *         if (count >= target) return true; // 조기 종료로 최적화
 *     }
 *     return count >= target;
 * }
 * 
 * [매개변수 탐색의 핵심]
 * 1. 단조성: 길이가 작을수록 더 많은 랜선을 만들 수 있음
 * 2. 최적화: 조건을 만족하는 최대값을 찾기
 * 3. 이분 탐색으로 O(log(max_length)) 시간에 해결
 * 
 * [구현 시 주의사항]
 * 1. 오버플로우 방지:
 *    - int 대신 long 사용 (길이가 2^31-1까지 가능)
 *    - count 변수도 long으로 선언
 * 
 * 2. 범위 설정:
 *    - left = 1 (0이면 무한대가 됨)
 *    - right = Arrays.stream(cables).max().orElse(0)
 * 
 * 3. 이분 탐색 로직:
 *    if (canMake(cables, mid, N)) {
 *        answer = mid;  // 가능한 경우 답 갱신
 *        left = mid + 1;  // 더 큰 길이 탐색
 *    } else {
 *        right = mid - 1;  // 더 작은 길이 탐색
 *    }
 * 
 * [코딩테스트 출제 패턴]
 * - 매개변수 탐색의 대표 문제
 * - "최대값의 최소", "최소값의 최대" 유형
 * - 이분 탐색 + 그리디 조합
 * 
 * [관련 문제들]
 * - 나무 자르기 (2805번) - 유사한 매개변수 탐색
 * - 공유기 설치 (2110번) - 거리 기반 매개변수 탐색
 * - 징검다리 건너기 (프로그래머스) - 레벨 기반 매개변수 탐색
 * 
 * [시간복잡도] O(K × log(max_length))
 * [공간복잡도] O(K) - 랜선 길이 배열 저장
 * 
 * [실제 구현 팁]
 * - BufferedReader로 빠른 입력 처리
 * - 조기 종료 조건으로 성능 최적화
 * - 오버플로우 체크 필수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        
        long[] cables = new long[K];
        long maxLength = 0;
        
        // 랜선 길이 입력 및 최대 길이 찾기
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            maxLength = Math.max(maxLength, cables[i]);
        }
        
        // 이분 탐색 범위 설정
        long left = 1;
        long right = maxLength;
        long answer = 0;
        
        // 이분 탐색 수행
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (canMake(cables, mid, N)) {
                answer = mid;  // 가능한 경우 답 갱신
                left = mid + 1;  // 더 큰 길이 탐색
            } else {
                right = mid - 1;  // 더 작은 길이 탐색
            }
        }
        
        System.out.println(answer);
    }
    
    /**
     * 주어진 길이로 N개 이상의 랜선을 만들 수 있는지 확인
     * @param cables 기존 랜선들의 길이 배열
     * @param length 자를 랜선의 길이
     * @param target 목표 개수
     * @return N개 이상 만들 수 있으면 true, 아니면 false
     */
    private static boolean canMake(long[] cables, long length, int target) {
        long count = 0;
        
        for (long cable : cables) {
            count += cable / length;
            // 조기 종료: 이미 목표 개수를 넘었다면 더 계산할 필요 없음
            if (count >= target) {
                return true;
            }
        }
        
        return count >= target;
    }
}