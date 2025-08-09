package p2805;

/*
 * 백준 2805번: 나무 자르기
 * https://www.acmicpc.net/problem/2805
 * 
 * [문제 분류] 이분 탐색 (Binary Search) / 매개변수 탐색
 * [난이도] Silver 2
 * 
 * [문제 요약]
 * 상근이는 나무 M미터가 필요하다. 근처에 나무를 구입할 곳이 모두 망해버렸기 때문에, 
 * 정부에 벌목 허가를 요청했다. 정부는 상근이네 집 근처의 나무 한 줄에 대한 벌목을 허가했고, 
 * 상근이는 새로 사온 목재절단기를 이용해서 나무를 자르려고 한다.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 1,000,000 (나무의 수)
 * - 1 ≤ M ≤ 2,000,000,000 (필요한 나무의 길이)
 * - 0 ≤ 각 나무의 높이 ≤ 1,000,000,000
 * 
 * [알고리즘 설명 - 매개변수 탐색]
 * 1. 핵심 아이디어: 절단기의 높이를 매개변수로 하여 이분 탐색
 * 2. 특정 높이로 잘랐을 때 M미터 이상의 나무를 얻을 수 있는지 확인
 * 3. 조건을 만족하는 최대 높이를 찾는 최적화 문제
 * 
 * [이분 탐색 범위 설정]
 * - left = 0 (최소 절단 높이)
 * - right = max(나무 높이들) (최대 절단 높이)
 * - mid = (left + right) / 2
 * 
 * [판단 함수 (Decision Function)]
 * long getWood(int[] trees, int height) {
 *     long wood = 0;
 *     for (int tree : trees) {
 *         if (tree > height) {
 *             wood += tree - height;
 *         }
 *     }
 *     return wood;
 * }
 * 
 * [매개변수 탐색의 특징]
 * 1. 단조성: 절단 높이가 낮을수록 더 많은 나무를 얻을 수 있음
 * 2. 최적화: 조건을 만족하는 최대 높이 찾기
 * 3. 상한/하한 탐색: Upper bound 방식 활용
 * 
 * [구현 시 주의사항]
 * 1. 오버플로우 방지:
 *    - 나무 개수 × 최대 높이 = 10^9 × 10^6 = 10^15 > int 범위
 *    - wood 변수는 long 타입 사용 필수
 * 
 * 2. 범위 설정 주의:
 *    - left = 0 (나무를 전혀 자르지 않는 경우도 고려)
 *    - 모든 나무가 0인 경우도 있을 수 있음
 * 
 * 3. 이분 탐색 로직:
 *    if (getWood(trees, mid) >= M) {
 *        answer = mid;  // 조건 만족 시 답 갱신
 *        left = mid + 1;  // 더 높은 높이 탐색
 *    } else {
 *        right = mid - 1;  // 더 낮은 높이 탐색
 *    }
 * 
 * [랜선 자르기(1654)와의 차이점]
 * 1. 1654번: "개수"를 기준으로 판단 → 나누기 연산
 * 2. 2805번: "길이"를 기준으로 판단 → 뺄셈 연산
 * 3. 둘 다 매개변수 탐색이지만 계산 방식이 다름
 * 
 * [코딩테스트 관점]
 * - 매개변수 탐색의 대표 문제 중 하나
 * - 대용량 데이터 처리 능력 검증
 * - 오버플로우 처리 능력 확인
 * 
 * [최적화 기법]
 * 1. 조기 종료: 필요한 나무를 얻으면 즉시 반환
 * 2. BufferedReader: 대용량 입력 처리
 * 3. 불필요한 연산 최소화
 * 
 * [관련 문제들]
 * - 랜선 자르기 (1654번) - 개수 기반 매개변수 탐색
 * - 공유기 설치 (2110번) - 거리 기반 매개변수 탐색
 * - 용돈 관리 (6236번) - 금액 기반 매개변수 탐색
 * 
 * [시간복잡도] O(N × log(max_height))
 * [공간복잡도] O(N) - 나무 높이 배열 저장
 * 
 * [실무 활용]
 * - 자원 할당 최적화 문제
 * - 임계값 결정 문제
 * - 제약 조건하에서의 최대/최소값 탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        long M = Long.parseLong(st.nextToken());  // 필요한 나무의 길이
        
        int[] trees = new int[N];
        int maxHeight = 0;
        
        st = new StringTokenizer(br.readLine());
        
        // 나무 높이 입력 및 최대 높이 찾기
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }
        
        // 이분 탐색 범위 설정
        int left = 0;
        int right = maxHeight;
        int answer = 0;
        
        // 이분 탐색 수행
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (getWood(trees, mid) >= M) {
                answer = mid;  // 조건 만족 시 답 갱신
                left = mid + 1;  // 더 높은 높이 탐색
            } else {
                right = mid - 1;  // 더 낮은 높이 탐색
            }
        }
        
        System.out.println(answer);
    }
    
    /**
     * 주어진 높이로 잘랐을 때 얻을 수 있는 나무의 총 길이 계산
     * @param trees 나무들의 높이 배열
     * @param height 절단기의 높이
     * @return 얻을 수 있는 나무의 총 길이
     */
    private static long getWood(int[] trees, int height) {
        long wood = 0;
        
        for (int tree : trees) {
            if (tree > height) {
                wood += tree - height;
            }
        }
        
        return wood;
    }
}