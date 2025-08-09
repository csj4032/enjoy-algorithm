package p1927;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 제목 : 최소 힙
 * 링크 : https://www.acmicpc.net/problem/1927
 * 분류 : 자료구조, 힙, 우선순위 큐
 * 
 * === 문제 해설 ===
 * 최소 힙 자료구조를 구현하여 다음 연산들을 효율적으로 처리하는 문제입니다.
 * 1) 자연수 x 입력: 힙에 x 삽입
 * 2) 0 입력: 최솟값 출력 후 제거 (빈 힙이면 0 출력)
 * 
 * === 힙(Heap)의 수학적/이론적 배경 ===
 * 1) 완전 이진 트리(Complete Binary Tree):
 *    - 마지막 레벨을 제외한 모든 레벨이 완전히 채워짐
 *    - 마지막 레벨은 왼쪽부터 순서대로 채워짐
 *    - 배열로 구현시 인덱스 관계: parent(i) = i/2, left(i) = 2i, right(i) = 2i+1
 * 
 * 2) 힙 속성(Heap Property):
 *    - 최소 힙: parent(i) ≤ child(i) for all i
 *    - 최대 힙: parent(i) ≥ child(i) for all i
 *    - 형제 노드 간에는 순서 관계 없음
 * 
 * 3) 부분 순서 관계(Partial Order):
 *    - 반사성(Reflexive): a ≤ a
 *    - 반대칭성(Antisymmetric): a ≤ b and b ≤ a → a = b
 *    - 이행성(Transitive): a ≤ b and b ≤ c → a ≤ c
 * 
 * === 힙 연산의 알고리즘 설계 ===
 * 1) 삽입(Insert) 연산:
 *    - 새 원소를 트리의 마지막 위치에 추가
 *    - 부모와 비교하며 힙 속성을 만족할 때까지 상향 이동
 *    - Bubble Up / Percolate Up / Heapify Up
 *    - 시간복잡도: O(log n)
 * 
 * 2) 삭제(Extract-Min) 연산:
 *    - 루트 노드(최솟값) 제거
 *    - 마지막 노드를 루트로 이동
 *    - 자식들과 비교하며 힙 속성을 만족할 때까지 하향 이동
 *    - Bubble Down / Percolate Down / Heapify Down
 *    - 시간복잡도: O(log n)
 * 
 * 3) 최솟값 조회(Find-Min) 연산:
 *    - 루트 노드의 값 반환
 *    - 시간복잡도: O(1)
 * 
 * === 구현 세부사항 ===
 * 1) Java PriorityQueue 내부 구조:
 *    - Object[] queue 배열 사용
 *    - 기본 용량 11, 동적 확장
 *    - Comparator를 통한 사용자 정의 순서
 * 
 * 2) 메모리 레이아웃:
 *    - 인덱스 0부터 사용 (구현에 따라 다름)
 *    - 캐시 친화적 메모리 접근
 *    - 포인터 없이 배열 인덱스만으로 탐색
 * 
 * 3) 동적 크기 조정:
 *    - 용량 부족시 약 1.5배 확장
 *    - 메모리 재할당과 복사 비용
 *    - 분할 상환 분석(Amortized Analysis)
 * 
 * === 시간/공간 복잡도 ===
 * - 삽입: O(log n) - 최대 트리 높이만큼 이동
 * - 삭제: O(log n) - 최대 트리 높이만큼 이동
 * - 조회: O(1) - 루트 노드 접근
 * - 공간: O(n) - n개 원소 저장
 * - 트리 높이: O(log n) - 완전 이진 트리
 * 
 * === 고급 최적화 기법 ===
 * 1) d-ary 힙:
 *    - 각 노드가 d개의 자식을 가짐
 *    - 삽입 최적화: O(log_d n)
 *    - 삭제 시 더 많은 비교 필요
 * 
 * 2) 피보나치 힙(Fibonacci Heap):
 *    - 삽입: O(1) amortized
 *    - decrease-key: O(1) amortized
 *    - 다익스트라 알고리즘에서 효과적
 * 
 * 3) 이항 힙(Binomial Heap):
 *    - 여러 힙의 효율적 병합
 *    - Union: O(log n)
 *    - 이항 트리들의 집합
 * 
 * === 실전 코딩테스트 대비 포인트 ===
 * 1) 언어별 구현 차이:
 *    - Java: PriorityQueue (최소 힙 기본)
 *    - C++: priority_queue (최대 힙 기본)
 *    - Python: heapq (최소 힙 기본)
 * 
 * 2) 주의사항:
 *    - 빈 힙에서 삭제시 예외 처리
 *    - 오버플로우 방지 (큰 수 처리)
 *    - null 값 처리
 * 
 * 3) 최적화 팁:
 *    - StringBuilder로 출력 최적화
 *    - 미리 용량 설정으로 재할당 방지
 *    - 적절한 자료형 선택
 * 
 * === 힙의 고급 활용 ===
 * 1) 우선순위 큐 응용:
 *    - 작업 스케줄링
 *    - 이벤트 시뮬레이션
 *    - A* 탐색 알고리즘
 * 
 * 2) 그래프 알고리즘:
 *    - 다익스트라 최단경로
 *    - 프림 최소신장트리
 *    - 허프만 코딩
 * 
 * 3) 통계 및 정렬:
 *    - 힙 정렬(Heap Sort)
 *    - k번째 최솟값/최댓값
 *    - 중앙값 유지
 * 
 * === 관련 자료구조 비교 ===
 * 1) 이진 탐색 트리 vs 힙:
 *    - BST: 전체 순서, O(log n) 검색
 *    - 힙: 부분 순서, O(1) 최솟값
 * 
 * 2) 정렬된 배열 vs 힙:
 *    - 배열: O(n) 삽입, O(1) 최솟값
 *    - 힙: O(log n) 삽입, O(1) 최솟값
 * 
 * 3) 연결 리스트 vs 힙:
 *    - 리스트: O(1) 삽입, O(n) 최솟값
 *    - 힙: O(log n) 삽입, O(1) 최솟값
 * 
 * === 실제 시스템에서의 활용 ===
 * 1) 운영체제:
 *    - CPU 스케줄러 (우선순위 기반)
 *    - 메모리 관리 (페이지 교체)
 *    - I/O 스케줄링
 * 
 * 2) 네트워크:
 *    - 패킷 전송 우선순위
 *    - QoS (Quality of Service)
 *    - 라우팅 알고리즘
 * 
 * 3) 데이터베이스:
 *    - 쿼리 최적화
 *    - 인덱스 구조
 *    - 캐시 교체 정책
 * 
 * === 확장 문제들 ===
 * 1) 최대 힙 구현
 * 2) k개의 정렬된 배열 병합
 * 3) 스트리밍 데이터에서 k번째 최솟값
 * 4) 중앙값 유지하는 자료구조
 * 5) Top-K 빈도수 문제
 * 
 * === 힙의 수학적 성질 ===
 * 1) 높이: floor(log₂ n)
 * 2) 리프 노드 개수: ceil(n/2)
 * 3) 내부 노드 개수: floor(n/2)
 * 4) 레벨 k의 노드 개수: 최대 2^k
 * 5) 힙 구성 시간: O(n) - bottom-up 방식
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();  // 연산의 개수
        
        // 최소 힙 (우선순위 큐) 생성
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            Long l = sc.nextLong();
            
            if (l != 0) {
                // 자연수가 입력되면 힙에 추가
                priorityQueue.add(l);
            } else {
                // 0이 입력되면 최솟값 출력 및 제거
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");  // 힙이 비어있으면 0 출력
                } else {
                    sb.append(priorityQueue.poll()).append("\n");  // 최솟값 출력 및 제거
                }
            }
        }
        System.out.println(sb.toString());
    }
}
