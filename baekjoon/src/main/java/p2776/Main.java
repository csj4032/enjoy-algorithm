package p2776;

/*
 * 백준 2776번: 암기왕
 * https://www.acmicpc.net/problem/2776
 * 
 * [문제 분류] 이분 탐색 (Binary Search) / 자료구조
 * [난이도] Silver 4
 * 
 * [문제 요약]
 * 연종이는 엄청난 기억력을 가지고 있다. 그래서 하루에 외운 수들 중에서 
 * 친구들이 말하는 수가 있었는지 없었는지를 바로바로 알 수 있다.
 * 연종이가 하루에 외운 수들이 주어졌을 때, 친구들이 말하는 수가 
 * 연종이가 외운 수들 중에 있는지 없는지를 알려주자.
 * 
 * [제약 조건]
 * - 1 ≤ T ≤ 10 (테스트 케이스 수)
 * - 1 ≤ N ≤ 1,000,000 (연종이가 외운 수의 개수)
 * - 1 ≤ M ≤ 1,000,000 (친구들이 말하는 수의 개수)
 * - -2^31 ≤ 수 ≤ 2^31 - 1
 * 
 * [알고리즘 설명]
 * 1. 기본적인 존재 여부 탐색 문제 (1920번과 유사)
 * 2. 하지만 테스트 케이스가 여러 개이므로 효율성이 더 중요
 * 3. 이분 탐색, HashSet, HashMap 등 다양한 방법 가능
 * 
 * [구현 방법들]
 * 1. 이분 탐색 (표준 방법):
 *    Arrays.sort(memorized);
 *    for (query) {
 *        boolean found = Arrays.binarySearch(memorized, query) >= 0;
 *    }
 *    시간복잡도: O(N log N + M log N)
 * 
 * 2. HashSet 사용 (더 효율적):
 *    Set<Integer> set = new HashSet<>();
 *    for (num : memorized) set.add(num);
 *    for (query) {
 *        boolean found = set.contains(query);
 *    }
 *    시간복잡도: O(N + M) 평균
 * 
 * 3. HashMap 사용 (불필요하지만 가능):
 *    Map<Integer, Boolean> map = new HashMap<>();
 *    시간복잡도: O(N + M) 평균
 * 
 * [이분 탐색 vs HashSet 비교]
 * 
 * 이분 탐색:
 * - 메모리 효율적 (추가 공간 거의 불필요)
 * - 안정적인 성능 (최악 O(log N))
 * - 구현이 직관적
 * - 정렬 비용 필요
 * 
 * HashSet:
 * - 더 빠른 평균 성능 (O(1))
 * - 해시 충돌 시 성능 저하 가능
 * - 추가 메모리 사용
 * - 정렬 불필요
 * 
 * [테스트 케이스 처리]
 * - 각 테스트 케이스마다 독립적으로 처리
 * - 입력 순서: T → (N, 수들, M, 쿼리들) × T번
 * - 출력: 각 쿼리마다 1(있음) 또는 0(없음)
 * 
 * [BufferedReader 사용 이유]
 * - N, M이 최대 100만 개씩
 * - Scanner로는 시간 초과 가능성 높음
 * - StringTokenizer와 함께 사용하여 빠른 입력 처리
 * 
 * [Arrays.binarySearch() 활용]
 * - 정렬된 배열에서 특정 값 탐색
 * - 반환값: 찾으면 인덱스, 못 찾으면 -(insertion point) - 1
 * - 존재 여부 확인: result >= 0
 * 
 * [직접 이분 탐색 구현 vs 라이브러리]
 * 직접 구현:
 * int binarySearch(int[] arr, int target) {
 *     int left = 0, right = arr.length - 1;
 *     while (left <= right) {
 *         int mid = (left + right) / 2;
 *         if (arr[mid] == target) return mid;
 *         else if (arr[mid] < target) left = mid + 1;
 *         else right = mid - 1;
 *     }
 *     return -1;
 * }
 * 
 * 라이브러리 사용:
 * - 더 안전하고 검증된 구현
 * - 코드가 간결함
 * - 실수 가능성 적음
 * 
 * [코딩테스트 관점]
 * - 기본적인 탐색 문제지만 대용량 데이터 처리 능력 검증
 * - 시간 복잡도 최적화 능력 확인
 * - 적절한 자료구조 선택 능력 평가
 * 
 * [관련 문제들]
 * - 수 찾기 (1920번) - 기본 버전
 * - 숫자 카드 2 (10816번) - 개수까지 구하는 버전
 * - 좌표 압축 (18870번) - 이분 탐색 응용
 * 
 * [실제 구현 팁]
 * - 테스트 케이스별로 배열/집합 초기화 필요
 * - StringBuilder로 출력 최적화 가능
 * - 입력 범위가 int 범위 내이므로 long 불필요
 * 
 * [시간복잡도] 
 * - 이분 탐색: O(T × (N log N + M log N))
 * - HashSet: O(T × (N + M)) 평균
 * 
 * [공간복잡도] 
 * - 이분 탐색: O(N)
 * - HashSet: O(N) + 해시 테이블 오버헤드
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        for (int t = 0; t < T; t++) {
            // 연종이가 외운 수들 입력
            int N = Integer.parseInt(br.readLine());
            int[] memorized = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                memorized[i] = Integer.parseInt(st.nextToken());
            }
            
            // 이분 탐색을 위한 정렬
            Arrays.sort(memorized);
            
            // 친구들이 말하는 수들 처리
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < M; i++) {
                int query = Integer.parseInt(st.nextToken());
                
                // Arrays.binarySearch() 사용
                if (Arrays.binarySearch(memorized, query) >= 0) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }
        
        System.out.print(sb.toString());
    }
    
    /**
     * 직접 구현한 이분 탐색 (참고용)
     * @param arr 정렬된 배열
     * @param target 찾을 값
     * @return 찾으면 인덱스, 못 찾으면 -1
     */
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // 찾지 못함
    }
}