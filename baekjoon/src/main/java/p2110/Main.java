package p2110;

/*
 * 백준 2110번: 공유기 설치
 * https://www.acmicpc.net/problem/2110
 * 
 * [문제 분류] 이분 탐색 (Binary Search) / 매개변수 탐색
 * [난이도] Gold 4
 * 
 * [문제 요약]
 * 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, x2, ..., xN이고, 
 * 집 여러개가 같은 좌표를 가지는 일은 없다.
 * 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다.
 * 최대한 많은 곳에서 와이파이를 사용하려고 하므로, 한 집에는 공유기를 하나만 설치할 수 있고,
 * 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
 * 
 * [제약 조건]
 * - 2 ≤ N ≤ 200,000 (집의 개수)
 * - 2 ≤ C ≤ N (공유기의 개수)
 * - 0 ≤ xi ≤ 1,000,000,000 (집의 좌표)
 * 
 * [알고리즘 설명 - 매개변수 탐색]
 * 1. 핵심 아이디어: 공유기 사이의 최소 거리를 매개변수로 하여 이분 탐색
 * 2. 특정 거리 이상을 유지하며 C개의 공유기를 설치할 수 있는지 확인
 * 3. 조건을 만족하는 최대 거리를 찾는 최적화 문제
 * 
 * [전처리 과정]
 * - 집의 좌표를 오름차순으로 정렬
 * - 정렬된 상태에서 탐욕적으로 공유기 설치
 * 
 * [이분 탐색 범위 설정]
 * - left = 1 (최소 거리)
 * - right = houses[N-1] - houses[0] (최대 가능 거리)
 * - mid = (left + right) / 2
 * 
 * [판단 함수 (Decision Function)]
 * boolean canInstall(int[] houses, int distance, int routers) {
 *     int count = 1; // 첫 번째 집에는 무조건 설치
 *     int lastPos = houses[0];
 *     
 *     for (int i = 1; i < houses.length; i++) {
 *         if (houses[i] - lastPos >= distance) {
 *             count++;
 *             lastPos = houses[i];
 *             if (count >= routers) return true; // 조기 종료
 *         }
 *     }
 *     return count >= routers;
 * }
 * 
 * [그리디 전략]
 * 1. 가장 왼쪽 집부터 시작
 * 2. 이전 공유기로부터 distance 이상 떨어진 첫 번째 집에 설치
 * 3. 이 방식이 최적인 이유: 더 왼쪽에 설치할수록 나머지 공간이 많아짐
 * 
 * [구현 시 주의사항]
 * 1. 정렬 필수: 좌표를 정렬해야 그리디 전략 적용 가능
 * 2. 조기 종료: count가 목표에 도달하면 즉시 true 반환
 * 3. 첫 번째 집: 항상 첫 번째 집에 공유기 설치로 시작
 * 
 * [이분 탐색 로직]
 * if (canInstall(houses, mid, C)) {
 *     answer = mid;  // 조건 만족 시 답 갱신
 *     left = mid + 1;  // 더 큰 거리 탐색
 * } else {
 *     right = mid - 1;  // 더 작은 거리 탐색
 * }
 * 
 * [다른 매개변수 탐색 문제와의 차이점]
 * 1. 1654번(랜선): 길이 → 개수 (나누기)
 * 2. 2805번(나무): 높이 → 길이 (뺄셈)
 * 3. 2110번(공유기): 거리 → 설치 가능 여부 (그리디)
 * 
 * [수학적 증명]
 * - 최적해의 존재성: 거리가 작을수록 더 많은 공유기 설치 가능 (단조성)
 * - 그리디의 정당성: 왼쪽부터 설치하는 것이 항상 최적
 * 
 * [코딩테스트 관점]
 * - 매개변수 탐색 + 그리디의 조합
 * - 정렬과 이분 탐색의 연계
 * - 대용량 데이터에서의 효율성 검증
 * 
 * [최적화 포인트]
 * 1. Arrays.sort() 사용으로 안정적인 정렬
 * 2. 조기 종료로 불필요한 계산 방지
 * 3. BufferedReader로 빠른 입력 처리
 * 
 * [관련 문제들]
 * - 랜선 자르기 (1654번) - 길이 기반 매개변수 탐색
 * - 나무 자르기 (2805번) - 높이 기반 매개변수 탐색
 * - 징검다리 (프로그래머스) - 거리 기반 매개변수 탐색
 * 
 * [실무 응용]
 * - 네트워크 기지국 배치 최적화
 * - 물류 창고 위치 결정
 * - 자원 배치 간격 최적화
 * 
 * [시간복잡도] O(N log N + N × log(max_distance))
 * [공간복잡도] O(N) - 집 좌표 배열 저장
 * 
 * [문제 해결 패턴]
 * 1. 정렬 → 2. 매개변수 설정 → 3. 이분 탐색 → 4. 그리디 검증
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
        
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수
        
        int[] houses = new int[N];
        
        // 집의 좌표 입력
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        
        // 좌표 정렬 (그리디 전략을 위해 필수)
        Arrays.sort(houses);
        
        // 이분 탐색 범위 설정
        int left = 1; // 최소 거리
        int right = houses[N-1] - houses[0]; // 최대 가능 거리
        int answer = 0;
        
        // 이분 탐색 수행
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canInstall(houses, mid, C)) {
                answer = mid;  // 조건 만족 시 답 갱신
                left = mid + 1;  // 더 큰 거리 탐색
            } else {
                right = mid - 1;  // 더 작은 거리 탐색
            }
        }
        
        System.out.println(answer);
    }
    
    /**
     * 주어진 최소 거리를 유지하며 공유기를 설치할 수 있는지 확인
     * @param houses 정렬된 집 좌표 배열
     * @param distance 공유기 사이의 최소 거리
     * @param routers 설치해야 할 공유기 개수
     * @return 설치 가능하면 true, 아니면 false
     */
    private static boolean canInstall(int[] houses, int distance, int routers) {
        int count = 1; // 첫 번째 집에는 무조건 공유기 설치
        int lastPos = houses[0]; // 마지막으로 공유기를 설치한 위치
        
        // 두 번째 집부터 탐색
        for (int i = 1; i < houses.length; i++) {
            // 이전 공유기로부터 distance 이상 떨어져 있으면 설치
            if (houses[i] - lastPos >= distance) {
                count++;
                lastPos = houses[i];
                
                // 조기 종료: 필요한 개수만큼 설치했으면 더 확인할 필요 없음
                if (count >= routers) {
                    return true;
                }
            }
        }
        
        return count >= routers;
    }
}