package p2042;

import java.util.Scanner;

/**
 * 백준 2042번: 구간 합 구하기 (Gold 1)
 * https://www.acmicpc.net/problem/2042
 * 
 * == 문제 분류 ==
 * 자료 구조, 세그먼트 트리, 펜윅 트리
 * 
 * == 알고리즘 이론 ==
 * 1. 세그먼트 트리 (Segment Tree)
 *    - 구간 쿼리를 효율적으로 처리하는 트리 자료구조
 *    - 완전 이진 트리 형태로 구성
 *    - 각 노드는 특정 구간의 정보를 저장 (합, 최솟값, 최댓값 등)
 * 
 * 2. 구간 합 쿼리 (Range Sum Query)
 *    - 배열의 특정 구간 [l, r]의 합 계산
 *    - 단순 반복문: O(n) vs 세그먼트 트리: O(log n)
 *    - 업데이트와 쿼리가 모두 빈번한 경우 최적
 * 
 * 3. 레이지 프로퍼게이션 (Lazy Propagation)
 *    - 구간 업데이트를 위한 최적화 기법
 *    - 업데이트를 지연시켜 필요시에만 전파
 *    - 구간 업데이트: O(log n)
 * 
 * == 핵심 아이디어 ==
 * 1. 트리 구성: tree[node] = tree[2*node] + tree[2*node+1]
 * 2. 구간 쿼리: 재귀적으로 필요한 부분만 탐색
 * 3. 포인트 업데이트: 리프에서 루트까지 경로상 모든 노드 갱신
 * 4. 메모리: 4*N 크기의 배열로 충분 (완전 이진 트리)
 * 
 * == 시간복잡도 ==
 * - 초기화: O(n)
 * - 포인트 업데이트: O(log n)
 * - 구간 쿼리: O(log n)
 * - 전체: O((m+k) log n)
 * 
 * == 공간복잡도 ==
 * O(4n) - 세그먼트 트리 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 1-based 인덱싱으로 계산 간소화
 * 2. 비트 시프트 연산으로 성능 향상
 * 3. 재귀 대신 반복문으로 구현 가능
 * 4. 펜윅 트리로 더 간단한 구현 가능
 * 
 * == 대안: 펜윅 트리 (Binary Indexed Tree) ==
 * - 더 적은 메모리 사용 (n+1 크기)
 * - 구현이 더 간단
 * - 구간 합에 특화됨
 * 
 * == 실무 응용 ==
 * - 데이터베이스 인덱싱
 * - 실시간 통계 시스템
 * - 게임 랭킹 시스템
 * - 주식 거래 시스템
 * 
 * == 관련 심화 문제 ==
 * - 백준 2357: 최솟값과 최댓값 (Min/Max 세그먼트 트리)
 * - 백준 10868: 최솟값 (RMQ)  
 * - 백준 1275: 커피숍2 (구간 합 + 업데이트)
 * - 백준 2268: 수들의 합 7 (펜윅 트리)
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
