package p1655;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 제목 : 가운데를 말해요
 * 링크 : https://www.acmicpc.net/problem/1655
 * 분류 : 우선순위 큐, 힙, 자료구조
 * 
 * === 문제 해설 ===
 * 수가 하나씩 주어질 때마다 지금까지 받은 수들의 중간값(median)을 구하는 문제입니다.
 * 동적으로 변하는 데이터에서 중간값을 효율적으로 찾는 대표적인 문제입니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) 중간값(Median)의 정의:
 *    - 데이터를 정렬했을 때 가운데 위치하는 값
 *    - 홀수 개: 정확히 가운데 값
 *    - 짝수 개: 두 가운데 값 중 작은 값(문제 조건)
 * 
 * 2) 동적 중간값 문제:
 *    - 데이터가 스트림으로 들어올 때 실시간 중간값 계산
 *    - 전체 정렬: O(N log N) - 비효율적
 *    - 삽입 정렬: O(N²) - 더욱 비효율적
 *    - 두 개의 힙 활용: O(log N) - 최적해
 * 
 * 3) 힙을 이용한 분할 정복:
 *    - 작은 값들: 최대 힙 (Max Heap)
 *    - 큰 값들: 최소 힙 (Min Heap)
 *    - 균형 유지를 통한 중간값 접근
 * 
 * === 알고리즘 설계 ===
 * 1) 두 힙 구조:
 *    - maxHeap: 작은 절반의 값들 저장
 *    - minHeap: 큰 절반의 값들 저장
 *    - maxHeap.top() ≤ minHeap.top() 불변 조건 유지
 * 
 * 2) 크기 균형 조건:
 *    - |maxHeap.size() - minHeap.size()| ≤ 1
 *    - maxHeap.size() >= minHeap.size()
 *    - 중간값 = maxHeap.top()
 * 
 * 3) 삽입 알고리즘:
 *    - 새 원소를 적절한 힙에 삽입
 *    - 균형 조건 위반시 원소 이동
 *    - 불변 조건 검사 및 복구
 * 
 * === 구현 세부사항 ===
 * 1) 힙 구현 선택:
 *    - Java PriorityQueue 활용
 *    - maxHeap: Collections.reverseOrder()
 *    - minHeap: 기본 정렬 (오름차순)
 * 
 * 2) 삽입 로직:
 *    - 첫 번째 원소: maxHeap에 삽입
 *    - 이후 원소: maxHeap.top()과 비교하여 분할
 *    - 크기 균형 맞추기
 * 
 * 3) 균형 유지:
 *    - maxHeap이 2개 더 크면 minHeap으로 이동
 *    - minHeap이 더 크면 maxHeap으로 이동
 *    - 항상 maxHeap.size() >= minHeap.size() 유지
 * 
 * === 시간/공간 복잡도 ===
 * - 삽입 시간복잡도: O(log N) - 힙 연산
 * - 중간값 조회: O(1) - 힙의 루트 원소
 * - 전체 시간복잡도: O(N log N)
 * - 공간복잡도: O(N) - 두 개 힙의 크기 합
 * 
 * === 고급 최적화 기법 ===
 * 1) 메모리 최적화:
 *    - primitive 배열 기반 힙 구현
 *    - 객체 생성 오버헤드 제거
 *    - 캐시 지역성 향상
 * 
 * 2) 분기 예측 최적화:
 *    - 조건문 순서 최적화
 *    - 가장 빈번한 케이스를 앞쪽에 배치
 *    - 불필요한 비교 연산 제거
 * 
 * 3) 입출력 최적화:
 *    - BufferedReader + StringTokenizer
 *    - StringBuilder로 출력 버퍼링
 *    - System.out.println 대신 bulk output
 * 
 * === 대안 해결법 ===
 * 1) 균형 이진 탐색 트리:
 *    - TreeSet 또는 TreeMap 활용
 *    - 삽입: O(log N), 중간값: O(log N)
 *    - 구현 복잡도가 높음
 * 
 * 2) 정렬된 배열 + 이진 탐색:
 *    - 삽입: O(N), 중간값: O(1)
 *    - 데이터 크기가 작을 때만 실용적
 * 
 * 3) Order Statistics Tree:
 *    - k번째 원소를 O(log N)에 찾기
 *    - 구현이 복잡하지만 일반적
 * 
 * === 실전 코딩테스트 대비 포인트 ===
 * 1) 힙의 균형 유지:
 *    - maxHeap 크기 >= minHeap 크기
 *    - 크기 차이가 2 이상 나면 재조정
 *    - 불변 조건: maxHeap.top() ≤ minHeap.top()
 * 
 * 2) 경계 조건 처리:
 *    - 첫 번째 원소 삽입
 *    - 힙이 비어있는 경우
 *    - 같은 값이 여러 개인 경우
 * 
 * 3) 구현 주의사항:
 *    - PriorityQueue의 poll()은 null 반환 가능
 *    - 비교 연산자 방향 주의
 *    - 출력 형식 확인
 * 
 * === 확장 문제들 ===
 * 1) k번째 작은/큰 원소 찾기:
 *    - 힙 크기 비율을 k:(n-k)로 조정
 *    - 일반화된 순서 통계
 * 
 * 2) 슬라이딩 윈도우 중간값:
 *    - 고정 크기 윈도우에서 중간값
 *    - 원소 삭제 연산 추가 필요
 * 
 * 3) 가중치 있는 중간값:
 *    - 각 원소에 가중치 부여
 *    - 가중 중간값 계산
 * 
 * === 관련 알고리즘 패러다임 ===
 * 1) 분할 정복:
 *    - 데이터를 두 그룹으로 분할
 *    - 각 그룹에서 최적 구조 유지
 *    - 전체 최적해 도출
 * 
 * 2) 자료구조 설계:
 *    - 적절한 자료구조 선택
 *    - 불변 조건 정의 및 유지
 *    - 연산의 효율성 보장
 * 
 * 3) 온라인 알고리즘:
 *    - 스트리밍 데이터 처리
 *    - 실시간 결과 제공
 *    - 제한된 메모리 사용
 * 
 * === 실제 응용 사례 ===
 * 1) 실시간 데이터 분석:
 *    - 주식 가격 중간값 추적
 *    - 네트워크 지연시간 모니터링
 *    - 센서 데이터 이상치 탐지
 * 
 * 2) 추천 시스템:
 *    - 평점 중간값 계산
 *    - 사용자 선호도 분석
 *    - 콘텐츠 인기도 측정
 * 
 * 3) 통계 분석:
 *    - 실시간 중간값 추적
 *    - 분위수(quantile) 계산
 *    - 이상치(outlier) 탐지
 * 
 * === 힙 자료구조의 이해 ===
 * 1) 힙의 특성:
 *    - 완전 이진 트리 구조
 *    - 부모-자식 간 순서 관계
 *    - 삽입/삭제 O(log N)
 * 
 * 2) 최대힙 vs 최소힙:  
 *    - 최대힙: 부모 >= 자식
 *    - 최소힙: 부모 <= 자식
 *    - 루트가 최대/최소값
 * 
 * 3) 구현 기법:
 *    - 배열 기반 구현
 *    - 인덱스 관계: parent(i) = i/2, child(i) = 2i, 2i+1
 *    - heapify 연산으로 성질 유지
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // 최대 힙: 작은 절반의 값들 저장
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙: 큰 절반의 값들 저장
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            
            // 새로운 수를 적절한 힙에 삽입
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            
            // 힙 크기 균형 맞추기
            balanceHeaps(maxHeap, minHeap);
            
            // 중간값은 항상 maxHeap의 top
            sb.append(maxHeap.peek()).append('\n');
        }
        
        System.out.print(sb.toString());
    }
    
    /**
     * 두 힙의 크기 균형을 맞춤
     * 조건: maxHeap.size() >= minHeap.size() && |maxHeap.size() - minHeap.size()| <= 1
     * 
     * @param maxHeap 작은 값들을 저장하는 최대 힙
     * @param minHeap 큰 값들을 저장하는 최소 힙
     */
    private static void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        // maxHeap이 minHeap보다 2개 이상 많으면 조정
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        // minHeap이 maxHeap보다 많으면 조정
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
        // 불변 조건 검사: maxHeap.top <= minHeap.top
        if (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int maxTop = maxHeap.poll();
            int minTop = minHeap.poll();
            maxHeap.offer(minTop);
            minHeap.offer(maxTop);
        }
    }
}