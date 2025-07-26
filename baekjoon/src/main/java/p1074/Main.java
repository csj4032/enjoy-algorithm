package p1074;

/**
 * 백준 1074번: Z
 * https://www.acmicpc.net/problem/1074
 * 
 * 문제 분류: 분할정복, 재귀
 * 난이도: Silver I
 * 
 * 핵심 알고리즘:
 * - Z 순서 탐색 (Z-order traversal)
 * - 분할정복을 통한 좌표 탐색
 * 
 * 문제 해결 접근법:
 * 1. 2^N × 2^N 배열을 Z 모양으로 탐색
 * 2. 목표 좌표 (r, c)가 몇 번째로 방문되는지 계산
 * 3. 4개 사분면으로 나누어 재귀 처리
 * 4. 모든 경우를 탐색하는 완전 탐색 방식
 * 
 * 시간 복잡도: O(4^N) - 모든 칸 방문
 * 공간 복잡도: O(N) - 재귀 스택
 * 
 * 핵심 개념:
 * - Z-order curve (Morton code)
 * - 재귀적 분할정복
 * - 비트 연산을 통한 크기 계산
 */

import java.util.Scanner;

public class Main {

	static int visitCount = 0;  // 방문 순서 카운터
	static int N = 0;           // 배열 크기 지수
	static int targetR = 0;     // 목표 행
	static int targetC = 0;     // 목표 열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		targetR = sc.nextInt();
		targetC = sc.nextInt();
		
		// 2^N 크기의 배열에서 Z 순서로 탐색
		int size = 1 << N;  // 2^N 계산 (비트 시프트)
		zOrder(size, 0, 0);
	}

	/**
	 * Z 순서 탐색 함수 (완전 탐색)
	 * @param size 현재 영역의 크기
	 * @param startC 현재 영역의 시작 열 (x 좌표)
	 * @param startR 현재 영역의 시작 행 (y 좌표)
	 */
	private static void zOrder(int size, int startC, int startR) {
		// 기저 조건: 크기가 1일 때 (개별 셀 도달)
		if (size >> 1 == 0) {  // size가 1인지 비트 연산으로 확인
			if (startR == targetR && startC == targetC) {
				System.out.print(visitCount);
				return;
			}
			visitCount++;
			return;
		}

		int halfSize = size / 2;
		
		// Z 순서로 4개 사분면 탐색:
		// 1사분면 (왼쪽 위)
		zOrder(halfSize, startC, startR);
		
		// 2사분면 (오른쪽 위)  
		zOrder(halfSize, startC + halfSize, startR);
		
		// 3사분면 (왼쪽 아래)
		zOrder(halfSize, startC, startR + halfSize);
		
		// 4사분면 (오른쪽 아래)
		zOrder(halfSize, startC + halfSize, startR + halfSize);
	}
}

/*
 * Z 순서 (Z-order) 문제 상세 분석:
 * 
 * 1. Z 순서란?
 *    - 2차원 배열을 1차원으로 매핑하는 방법
 *    - 각 사분면을 Z 모양으로 탐색
 *    - Morton code 또는 Z-curve라고도 불림
 * 
 * 2. 탐색 순서 예시:
 *    2×2: 0 1    4×4: 0  1  4  5
 *         2 3          2  3  6  7
 *                      8  9  12 13
 *                      10 11 14 15
 * 
 * 3. 현재 구현의 특징:
 *    - 모든 칸을 실제로 방문하는 완전 탐색
 *    - 시간 복잡도가 O(4^N)으로 비효율적
 *    - N이 클 때 시간 초과 가능성
 * 
 * 4. 최적화 방법:
 *    - 목표 좌표가 있는 사분면만 탐색
 *    - 다른 사분면은 크기만 더하고 건너뛰기
 *    - 시간 복잡도를 O(log N)으로 개선 가능
 * 
 * 5. 최적화된 코드 예시:
 * static int optimizedZOrder(int size, int startR, int startC) {
 *     if (size == 1) return 0;
 *     
 *     int half = size / 2;
 *     int quadrantSize = half * half;
 *     
 *     if (targetR < startR + half && targetC < startC + half) {
 *         return optimizedZOrder(half, startR, startC);
 *     } else if (targetR < startR + half) {
 *         return quadrantSize + optimizedZOrder(half, startR, startC + half);
 *     } else if (targetC < startC + half) {
 *         return 2 * quadrantSize + optimizedZOrder(half, startR + half, startC);
 *     } else {
 *         return 3 * quadrantSize + optimizedZOrder(half, startR + half, startC + half);
 *     }
 * }
 * 
 * 6. 비트 연산 활용:
 *    - 2^N 계산: 1 << N
 *    - 크기가 1인지 확인: size >> 1 == 0
 *    - 절반 크기: size / 2 또는 size >> 1
 * 
 * 7. 실제 응용:
 *    - 공간 인덱싱 (spatial indexing)
 *    - 쿼드트리 (quadtree) 자료구조
 *    - 이미지 처리에서 블록 순서 지정
 *    - 캐시 효율성 개선
 * 
 * 관련 문제:
 * - 백준 11729: 하노이 탑 이동 순서 (재귀)
 * - 백준 2447: 별 찍기 - 10 (재귀적 패턴)
 * - 백준 1780: 종이의 개수 (분할정복)
 * - 백준 2263: 트리의 순회 (분할정복)
 */