package p2042;

import java.util.Scanner;

/**
 * 백준 2042번: 구간 합 구하기 (Gold 1)
 * https://www.acmicpc.net/problem/2042
 * 
 * === 문제 해설 ===
 * 배열의 특정 원소를 변경하면서 동시에 구간 합을 효율적으로 계산하는 문제입니다.
 * 세그먼트 트리의 가장 기본적이고 대표적인 응용 사례입니다.
 * 
 * === 세그먼트 트리의 수학적/이론적 배경 ===
 * 1) 완전 이진 트리(Complete Binary Tree) 구조:
 *    - 높이: ⌈log₂(n)⌉
 *    - 총 노드 수: 최대 4n개 (여유 공간 포함)
 *    - 리프 노드: 원본 배열의 각 원소
 *    - 내부 노드: 자식 노드들의 정보를 결합
 * 
 * 2) 분할 정복(Divide and Conquer) 원리:
 *    - 큰 구간을 작은 구간들로 분할
 *    - 각 구간의 정보를 독립적으로 관리
 *    - 쿼리 시 필요한 구간들만 결합
 * 
 * 3) 구간 분해(Range Decomposition) 이론:
 *    - 임의의 구간 [l,r]을 O(log n)개의 disjoint 구간으로 분해
 *    - 각 구간은 세그먼트 트리의 노드에 대응
 *    - 최적 분해의 유일성 보장
 * 
 * === 알고리즘 설계 원리 ===
 * 1) 트리 구성 전략:
 *    - 노드 인덱싱: 1-based (계산 편의성)
 *    - 부모-자식 관계: parent(i) = i/2, left(i) = 2i, right(i) = 2i+1
 *    - 구간 표현: [start, end] 형태로 각 노드가 담당하는 범위
 * 
 * 2) 초기화(Build) 알고리즘:
 *    - Bottom-up 방식: 리프부터 루트까지 구성
 *    - 시간복잡도: T(n) = 2T(n/2) + O(1) = O(n)
 *    - 공간복잡도: O(n) 추가 공간
 * 
 * 3) 쿼리(Query) 알고리즘:
 *    - 구간 [l,r]을 트리의 노드들로 분해
 *    - 완전 포함: 해당 노드 값 반환
 *    - 부분 겹침: 자식으로 재귀 탐색
 *    - 겹치지 않음: 0 반환
 * 
 * 4) 업데이트(Update) 알고리즘:
 *    - 리프 노드부터 루트까지 경로상 모든 노드 갱신
 *    - 차이값(diff) 전파로 효율성 향상
 *    - 시간복잡도: O(log n)
 * 
 * === 수학적 정확성 증명 ===
 * 1) 불변 조건(Invariant):
 *    - tree[node] = tree[2*node] + tree[2*node+1]
 *    - 모든 내부 노드에서 성립
 * 
 * 2) 정확성 증명:
 *    - 초기화: 귀납법으로 모든 노드가 올바른 값 저장
 *    - 업데이트: 불변 조건 유지하며 갱신
 *    - 쿼리: 분할 정복으로 올바른 합 계산
 * 
 * 3) 시간복잡도 분석:
 *    - 트리 높이: h = ⌈log₂(n)⌉
 *    - 각 연산마다 최대 h개 노드 방문
 *    - 따라서 O(log n) 보장
 * 
 * === 고급 구현 기법 ===
 * 1) 메모리 레이아웃 최적화:
 *    - 4n 크기 배열: 완전 이진 트리의 worst case
 *    - 캐시 지역성: 연속된 메모리 접근
 *    - 메모리 정렬: 64바이트 경계 정렬 고려
 * 
 * 2) 비트 연산 최적화:
 *    - node << 1: node * 2 (왼쪽 자식)
 *    - (node << 1) | 1: node * 2 + 1 (오른쪽 자식)
 *    - node >> 1: node / 2 (부모)
 * 
 * 3) 분기 예측 최적화:
 *    - 조건문 순서: 가장 빈번한 케이스를 앞에
 *    - 구간 겹침 검사의 효율화
 *    - 컴파일러 힌트 활용
 * 
 * 4) 재귀 최적화:
 *    - 꼬리 재귀 변환
 *    - 스택 기반 반복문 구현
 *    - 인라인 함수 최적화
 * 
 * === 확장 세그먼트 트리 기법 ===
 * 1) 레이지 프로퍼게이션(Lazy Propagation):
 *    - 구간 업데이트를 O(log n)에 처리
 *    - 지연 평가로 불필요한 연산 회피
 *    - 메모리: 추가 O(n) 공간 필요
 * 
 * 2) 지속적 세그먼트 트리(Persistent Segment Tree):
 *    - 모든 버전의 트리 상태 보관
 *    - 경로 복사(Path Copying) 기법
 *    - 시간 여행 쿼리 지원
 * 
 * 3) 동적 세그먼트 트리(Dynamic Segment Tree):
 *    - 좌표 압축 없이 큰 범위 처리
 *    - 필요시에만 노드 생성
 *    - 메모리 효율성 극대화
 * 
 * 4) 2D 세그먼트 트리:
 *    - 2차원 구간 쿼리 처리
 *    - 중첩된 세그먼트 트리 구조
 *    - 시간복잡도: O(log²n)
 * 
 * === 대안 자료구조 비교 ===
 * 1) 펜윅 트리(Binary Indexed Tree):
 *    - 장점: 더 적은 메모리, 간단한 구현
 *    - 단점: 구간 합에만 특화, 확장성 제한
 *    - 적용: 단순 구간 합 문제에 최적
 * 
 * 2) 스퀘어 루트 분해(Square Root Decomposition):
 *    - 장점: 구현 단순, 다양한 연산 지원
 *    - 단점: O(√n) 시간복잡도
 *    - 적용: 복잡한 쿼리 연산
 * 
 * 3) 스파스 테이블(Sparse Table):
 *    - 장점: O(1) 쿼리, 불변 배열에 최적
 *    - 단점: 업데이트 불가, O(n log n) 전처리
 *    - 적용: RMQ(Range Minimum Query)
 * 
 * === 실전 코딩테스트 최적화 ===
 * 1) 입출력 최적화:
 *    - BufferedReader + StringTokenizer
 *    - StringBuilder로 출력 버퍼링
 *    - System.setIn/setOut for local testing
 * 
 * 2) 자료형 선택:
 *    - int vs long: 오버플로우 고려
 *    - primitive vs wrapper: 성능 차이
 *    - 배열 vs Collection: 메모리 효율성
 * 
 * 3) 디버깅 전략:
 *    - 작은 테스트 케이스로 검증
 *    - 트리 시각화 도구 활용
 *    - 경계 조건 철저히 테스트
 * 
 * === 고급 수학적 응용 ===
 * 1) 결합 법칙(Associativity) 활용:
 *    - (a + b) + c = a + (b + c)
 *    - 연산 순서 무관하게 결과 동일
 *    - 병렬화 가능성
 * 
 * 2) 교환 법칙(Commutativity) 활용:
 *    - a + b = b + a
 *    - 구간 분해 순서 최적화
 *    - 캐시 효율성 향상
 * 
 * 3) 항등원(Identity Element):
 *    - 덧셈의 항등원: 0
 *    - 곱셈의 항등원: 1
 *    - 빈 구간 처리
 * 
 * === 실제 시스템 응용 사례 ===
 * 1) 데이터베이스 시스템:
 *    - B+ 트리 인덱스의 범위 쿼리
 *    - 집계 함수 최적화
 *    - 통계 정보 유지
 * 
 * 2) 분산 시스템:
 *    - 로드 밸런싱 알고리즘
 *    - 분산 캐시 시스템
 *    - MapReduce 프레임워크
 * 
 * 3) 게임 엔진:
 *    - 충돌 검출 시스템
 *    - 공간 분할 자료구조
 *    - 실시간 랭킹 시스템
 * 
 * 4) 금융 시스템:
 *    - 실시간 주가 지수 계산
 *    - 위험 관리 시스템
 *    - 알고리즘 트레이딩
 * 
 * === 관련 고급 문제들 ===
 * 1) 구간 업데이트 문제:
 *    - 백준 1275: 커피숍2
 *    - 백준 12837: 가계부
 *    - 백준 17408: 수열과 쿼리 24
 * 
 * 2) 다차원 세그먼트 트리:
 *    - 백준 11658: 구간 합 구하기 3
 *    - 백준 1849: 순열
 *    - Codeforces: 2D Range Sum
 * 
 * 3) 지속적 자료구조:
 *    - 백준 13537: 수열과 쿼리 1
 *    - 백준 16978: 수열과 쿼리 22
 *    - SPOJ: COT - Count on a tree
 * 
 * === 성능 벤치마크 ===
 * 1) 이론적 성능:
 *    - 세그먼트 트리: O(log n)
 *    - 펜윅 트리: O(log n), 더 작은 상수
 *    - 스퀘어 루트: O(√n)
 * 
 * 2) 실제 성능 차이:
 *    - 캐시 지역성의 영향
 *    - 분기 예측 성능
 *    - 컴파일러 최적화 효과
 * 
 * 3) 메모리 사용량:
 *    - 세그먼트 트리: 4n
 *    - 펜윅 트리: n+1
 *    - 스퀘어 루트: n + √n
 */
public class Main {

	private static long nn[];
	private static long tree[];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var k = sc.nextInt();
		m += k;
		nn = new long[n];
		tree = new long[4*n];
		for (int i = 0; i < n; i++) nn[i] = sc.nextInt();

		init(nn, tree, 1, 0, n - 1);

		while (m-- > 0) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			if (a == 1) {
				var c = sc.nextLong();
				var diff = c - nn[b - 1];
				nn[b - 1] = c;
				update(tree, 1, 0, n - 1, b - 1, diff);
			} else if (a == 2) {
				var c = sc.nextInt();
				System.out.println(sum(tree, 1, 0, n - 1, b - 1, c - 1));
			}
		}
	}

	private static long init(long[] nn, long[] tree, int node, int start, int end) {
		if (start == end) {
			return tree[node] = nn[start];
		}
		return tree[node] = init(nn, tree, node * 2, start, (start + end) / 2) + init(nn, tree, node * 2 + 1, (start + end) / 2 + 1, end);
	}

	private static long sum(long[] tree, int node, int start, int end, int left, int right) {
		if (end < left || start > right) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		return sum(tree, node * 2, start, (start + end) / 2, left, right) + sum(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	private static void update(long[] tree, int node, int start, int end, int index, long diff) {
		if (index < start || index > end) return;
		tree[node] = tree[node] + diff;
		if (start != end) {
			update(tree, node * 2, start, (start + end) / 2, index, diff);
			update(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
		}
	}
}
