package p2357;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2357번: 최솟값과 최댓값 (Gold 1)
 * https://www.acmicpc.net/problem/2357
 * 
 * == 문제 분류 ==
 * 자료 구조, 세그먼트 트리, RMQ
 * 
 * == 알고리즘 이론 ==
 * 1. 이중 세그먼트 트리 (Dual Segment Tree)
 *    - 최솟값과 최댓값을 동시에 관리
 *    - 두 개의 별도 트리 또는 하나의 트리에 두 값 저장
 *    - 각각 독립적인 RMQ와 Range Maximum Query
 * 
 * 2. 구간 최솟값/최댓값 쿼리
 *    - Min Segment Tree: 구간의 최솟값
 *    - Max Segment Tree: 구간의 최댓값
 *    - 동일한 구조, 다른 연산 (min vs max)
 * 
 * 3. 통합 vs 분리 구현
 *    - 분리: 두 개의 독립된 세그먼트 트리 (현재 구현)
 *    - 통합: 하나의 트리에 (min, max) pair 저장
 *    - 분리가 구현하기 쉽지만 메모리 2배 사용
 * 
 * == 핵심 아이디어 ==
 * 1. tree[node] = max(tree[2*node], tree[2*node+1]) (최댓값 트리)
 * 2. tree2[node] = min(tree2[2*node], tree2[2*node+1]) (최솟값 트리)
 * 3. 쿼리 시 두 트리를 독립적으로 탐색
 * 4. 경계값: MIN_VALUE (max), MAX_VALUE (min)
 * 
 * == 시간복잡도 ==
 * - 초기화: O(n) × 2 = O(n)
 * - 구간 쿼리: O(log n) × 2 = O(log n)
 * - 전체: O(n + m log n)
 * 
 * == 공간복잡도 ==
 * O(8n) - 두 개의 세그먼트 트리 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 두 트리를 동시에 초기화
 * 2. 쿼리 함수의 중복 제거 가능
 * 3. 제네릭을 이용한 통합 구현 가능
 * 4. SIMD 연산으로 병렬 처리 가능
 * 
 * == 메모리 최적화 ==
 * - Pair<Integer, Integer> 사용하여 하나의 트리로 구현
 * - 비트 연산으로 min/max를 하나의 long에 저장
 * - 하지만 가독성과 유지보수성 고려 필요
 * 
 * == 실무 응용 ==
 * - 주식 차트에서 특정 기간의 최고가/최저가
 * - 센서 데이터의 최대/최소 측정값 모니터링
 * - 게임에서 플레이어 스탯의 범위 계산
 * - 날씨 데이터의 최고/최저 온도 추적
 * 
 * == 관련 심화 문제 ==
 * - 백준 10868: 최솟값 (단일 RMQ)
 * - 백준 2042: 구간 합 구하기 (합 세그먼트 트리)
 * - 백준 1275: 커피숍2 (업데이트 포함)
 * - 백준 11505: 구간 곱 구하기 (곱셈 세그먼트 트리)
 */
public class Main {

	static int[] numbers;
	static int[] tree;
	static int[] tree2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = (int) Math.ceil(Math.log(n) / Math.log(2));
		numbers = new int[n];
		tree = new int[1 << (k + 1)];
		tree2 = new int[1 << (k + 1)];

		for (int i = 0; i < n; i++) numbers[i] = sc.nextInt();

		segment(1, 0, n - 1);
		segment2(1, 0, n - 1);
		System.out.println(Arrays.toString(tree));

		for (int i = 0; i < m; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int min = query2(l - 1, r - 1, 1, 0, n - 1);
			int max = query(l - 1, r - 1, 1, 0, n - 1);
			System.out.println(min + " " + max);
		}
	}

	private static int segment(int node, int start, int end) {
		if (start == end) return tree[node] = numbers[start];
		int mid = (start + end) / 2;
		return tree[node] = Math.max(segment(node * 2, start, mid), segment(node * 2 + 1, mid + 1, end));
	}

	private static int query(int left, int right, int node, int start, int end) {
		if (end < left || right < start) return Integer.MIN_VALUE;
		if (left <= start && right >= end) return tree[node];
		int mid = (start + end) / 2;
		return Math.max(query(left, right, node * 2, start, mid), query(left, right, node * 2 + 1, mid + 1, end));
	}

	private static int segment2(int node, int start, int end) {
		if (start == end) return tree2[node] = numbers[start];
		int mid = (start + end) / 2;
		return tree2[node] = Math.min(segment2(node * 2, start, mid), segment2(node * 2 + 1, mid + 1, end));
	}

	private static int query2(int left, int right, int node, int start, int end) {
		if (end < left || right < start) return Integer.MAX_VALUE;
		if (left <= start && right >= end) return tree2[node];
		int mid = (start + end) / 2;
		return Math.min(query2(left, right, node * 2, start, mid), query2(left, right, node * 2 + 1, mid + 1, end));
	}
}
