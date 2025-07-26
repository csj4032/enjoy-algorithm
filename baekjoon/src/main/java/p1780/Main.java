package p1780;

import java.util.Scanner;

/**
 * 백준 1780번: 종이의 개수 (Silver 2)
 * https://www.acmicpc.net/problem/1780
 * 
 * 문제 분류: 분할정복, 재귀
 * 핵심 알고리즘: 분할정복으로 영역을 9등분하여 처리
 * 
 * 해결 접근 방법:
 * 1. N×N 종이가 모두 같은 숫자로 채워져 있는지 확인
 * 2. 같은 숫자라면 해당 숫자의 개수를 증가
 * 3. 다른 숫자가 섞여있다면 9개의 영역으로 분할하여 재귀 호출
 * 4. 각 영역은 (N/3)×(N/3) 크기가 됨
 * 
 * 시간복잡도: O(N²) - 최악의 경우 모든 칸을 한 번씩 방문
 * 공간복잡도: O(N²) - 종이 정보 저장 + 재귀 스택 O(log₃ N)
 * 
 * 분할정복 과정:
 * 1. Base case: 현재 영역이 모두 같은 값으로 채워져 있음
 * 2. Divide: 9개의 (N/3)×(N/3) 영역으로 분할
 * 3. Conquer: 각 영역에 대해 재귀적으로 처리
 * 4. Combine: 각 영역의 결과를 합산
 * 
 * 관련 문제:
 * - 쿼드트리 (4분할)의 확장판 (9분할)
 * - 색종이 만들기와 유사한 패턴
 */
public class Main {

	// 각 종이의 개수를 저장 (-1: index 0, 0: index 1, 1: index 2)
	static int[] paperCount = new int[3];
	static int[][] paper; // 종이 정보

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		paper = new int[N][N];

		// 종이 정보 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}

		// 분할정복으로 종이 개수 계산
		divideAndConquer(0, 0, N);
		
		// 결과 출력 (-1, 0, 1 순서)
		System.out.println(paperCount[0]); // -1로 채워진 종이의 개수
		System.out.println(paperCount[1]); // 0으로 채워진 종이의 개수  
		System.out.println(paperCount[2]); // 1로 채워진 종이의 개수
		
		sc.close();
	}

	/**
	 * 분할정복으로 종이를 처리하는 함수
	 * 
	 * @param startRow 시작 행
	 * @param startCol 시작 열
	 * @param size 현재 영역의 크기
	 */
	private static void divideAndConquer(int startRow, int startCol, int size) {
		// 현재 영역이 모두 같은 숫자로 채워져 있는지 확인
		if (isUniform(startRow, startCol, size)) {
			// 같은 숫자라면 해당 숫자의 개수 증가
			int value = paper[startRow][startCol];
			paperCount[value + 1]++; // -1 → index 0, 0 → index 1, 1 → index 2
			return;
		}
		
		// 다른 숫자가 섞여있다면 9개 영역으로 분할
		int newSize = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// 각 영역에 대해 재귀 호출
				divideAndConquer(
					startRow + i * newSize, 
					startCol + j * newSize, 
					newSize
				);
			}
		}
	}

	/**
	 * 주어진 영역이 모두 같은 숫자로 채워져 있는지 확인
	 * 
	 * @param startRow 시작 행
	 * @param startCol 시작 열  
	 * @param size 영역 크기
	 * @return 모두 같은 숫자면 true, 아니면 false
	 */
	private static boolean isUniform(int startRow, int startCol, int size) {
		int firstValue = paper[startRow][startCol]; // 첫 번째 값을 기준으로 비교
		
		// 모든 칸을 확인
		for (int i = startRow; i < startRow + size; i++) {
			for (int j = startCol; j < startCol + size; j++) {
				if (paper[i][j] != firstValue) {
					return false; // 다른 값이 발견되면 false
				}
			}
		}
		
		return true; // 모든 값이 같으면 true
	}
}