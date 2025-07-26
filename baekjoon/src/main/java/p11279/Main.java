package p11279;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 제목 : 최대 힙
 * 링크 : https://www.acmicpc.net/problem/11279
 * 분류 : 힙, 우선순위 큐, 자료구조
 * 
 * === 문제 해설 ===
 * 최대 힙(Max Heap) 자료구조를 구현하고 연산을 수행하는 문제입니다.
 * 우선순위 큐의 기본 개념과 힙 자료구조의 특성을 이해하는 문제입니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) 힙(Heap)의 정의:
 *    - 완전 이진 트리(Complete Binary Tree) 구조
 *    - 부모 노드가 자식 노드보다 크거나 같음 (최대 힙)
 *    - 루트 노드가 전체에서 최대값
 * 
 * 2) 완전 이진 트리 특성:
 *    - 마지막 레벨을 제외하고 모든 레벨이 완전히 채워짐
 *    - 마지막 레벨은 왼쪽부터 채워짐
 *    - 배열로 효율적 표현 가능
 * 
 * 3) 힙의 수학적 성질:
 *    - 높이: O(log N)
 *    - N개 노드의 힙에서 리프 노드: ⌊N/2⌋ + 1 ~ N
 *    - 내부 노드: 1 ~ ⌊N/2⌋
 *    - 배열 인덱스 관계: parent(i) = i/2, left(i) = 2i, right(i) = 2i+1
 * 
 * === 알고리즘 설계 ===
 * 1) 삽입 연산 (Insert):
 *    - 새 원소를 힙의 마지막 위치에 추가
 *    - 부모와 비교하여 힙 성질 만족할 때까지 상향 이동
 *    - 시간복잡도: O(log N)
 * 
 * 2) 삭제 연산 (Extract-Max):
 *    - 루트 노드(최대값) 제거
 *    - 마지막 노드를 루트로 이동
 *    - 자식과 비교하여 힙 성질 만족할 때까지 하향 이동
 *    - 시간복잡도: O(log N)
 * 
 * 3) 힙 구성 (Build-Heap):
 *    - 임의의 배열을 힙으로 변환
 *    - Bottom-up 방식으로 heapify 적용
 *    - 시간복잡도: O(N)
 * 
 * === 구현 세부사항 ===
 * 1) Java PriorityQueue 활용:
 *    - 기본적으로 최소 힙으로 구현됨
 *    - Collections.reverseOrder()로 최대 힙 구현
 *    - Generic 타입으로 타입 안전성 보장
 * 
 * 2) 연산 처리:
 *    - offer(): 원소 삽입
 *    - poll(): 최대값 제거 및 반환
 *    - isEmpty(): 힙이 비어있는지 확인
 * 
 * 3) 출력 최적화:
 *    - StringBuilder 사용으로 문자열 연산 최적화
 *    - 각 결과를 즉시 append하여 메모리 효율성 향상
 * 
 * === 시간/공간 복잡도 ===
 * - 삽입: O(log N)
 * - 삭제: O(log N)  
 * - 최대값 조회: O(1)
 * - 공간복잡도: O(N)
 * - 전체 N번 연산: O(N log N)
 * 
 * === 고급 최적화 기법 ===
 * 1) 배열 기반 직접 구현:
 *    - PriorityQueue 오버헤드 제거
 *    - 인덱스 연산으로 부모-자식 관계 관리
 *    - 메모리 지역성 향상
 * 
 * 2) 캐시 효율성:
 *    - 연속된 메모리 배치
 *    - 프리페칭 최적화
 *    - 분기 예측 최적화
 * 
 * 3) SIMD 최적화:
 *    - 벡터화 가능한 연산 식별
 *    - 병렬 비교 연산
 *    - 하드웨어 가속 활용
 * 
 * === 힙 변형들 ===
 * 1) 이진 힙 (Binary Heap):
 *    - 가장 기본적인 형태
 *    - 완전 이진 트리 구조
 *    - 배열 기반 구현
 * 
 * 2) d-진 힙 (d-ary Heap):
 *    - 각 노드가 d개의 자식을 가짐
 *    - 더 얕은 트리 구조
 *    - 캐시 성능 개선 가능
 * 
 * 3) 피보나치 힙 (Fibonacci Heap):
 *    - decrease-key 연산이 O(1) 분할상환
 *    - 다익스트라, 프림 알고리즘 최적화
 *    - 복잡한 구현
 * 
 * === 실전 코딩테스트 대비 포인트 ===
 * 1) 힙 vs 정렬 선택:
 *    - k개 최대값만 필요: 힙 O(N log k)
 *    - 전체 정렬 필요: 정렬 O(N log N)
 *    - 동적 삽입/삭제: 힙 유리
 * 
 * 2) 구현 주의사항:
 *    - 힙이 비어있을 때 삭제 연산 처리
 *    - 0 출력 조건 확인
 *    - 타입 안전성 (Integer vs int)
 * 
 * 3) 메모리 고려사항:
 *    - 대용량 데이터: 메모리 제한 확인
 *    - GC 압박: primitive 타입 선호
 *    - 스택 오버플로우: 반복문 구현 고려
 * 
 * === 관련 알고리즘 패러다임 ===
 * 1) 탐욕 알고리즘:
 *    - 허프만 코딩
 *    - 다익스트라 최단경로
 *    - 프림 MST 알고리즘
 * 
 * 2) 분할 정복:
 *    - 힙 정렬 (Heap Sort)
 *    - 우선순위 큐 기반 병합
 *    - k-way 병합 정렬
 * 
 * 3) 동적 계획법:
 *    - 최적화 문제에서 상태 관리
 *    - 메모이제이션과 우선순위
 *    - 근사 알고리즘
 * 
 * === 실제 응용 사례 ===
 * 1) 운영체제:
 *    - 프로세스 스케줄링
 *    - 메모리 할당 알고리즘
 *    - I/O 요청 처리
 * 
 * 2) 네트워크:
 *    - 라우팅 알고리즘
 *    - QoS (Quality of Service)
 *    - 대역폭 할당
 * 
 * 3) 게임 개발:
 *    - A* 경로 탐색
 *    - 이벤트 시뮬레이션
 *    - 리소스 관리
 * 
 * === 확장 문제들 ===
 * 1) k번째 큰 원소 찾기
 * 2) 중간값 찾기 (두 힙 활용)
 * 3) 슬라이딩 윈도우 최대값
 * 4) 힙 정렬 구현
 * 5) 우선순위 큐를 이용한 시뮬레이션
 * 
 * === 성능 벤치마크 ===
 * 1) 삽입 성능:
 *    - PriorityQueue: 안정적
 *    - 직접 구현: 더 빠를 수 있음
 *    - TreeSet: 로그 팩터 차이
 * 
 * 2) 메모리 사용량:
 *    - PriorityQueue: 오버헤드 존재
 *    - 배열 기반: 메모리 효율적
 *    - 트리 기반: 포인터 오버헤드
 * 
 * 3) 캐시 성능:
 *    - 배열 기반: 높은 지역성
 *    - 트리 기반: 낮은 지역성
 *    - 접근 패턴에 따른 차이
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		PriorityQueue<Long> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
		for (int i = 0; i < n; i++) {
			Long l = sc.nextLong();
			if (l != 0) {
				priorityQueue.add(l);
			} else {
				if (priorityQueue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(priorityQueue.poll()).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
