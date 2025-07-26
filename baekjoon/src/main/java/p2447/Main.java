package p2447;

/**
 * 백준 2447번: 별 찍기 - 10
 * https://www.acmicpc.net/problem/2447
 * 
 * 문제 분류: 분할정복, 재귀
 * 난이도: Silver I
 * 
 * 핵심 알고리즘:
 * - 시에르핀스키 카펫 (Sierpinski Carpet) 패턴
 * - 재귀적 프랙탈 구조 생성
 * 
 * 문제 해결 접근법:
 * 1. N×N 크기를 3×3 블록으로 분할
 * 2. 가운데 블록은 공백, 나머지 8개 블록에 패턴 배치
 * 3. 각 좌표에서 모든 레벨의 3×3 패턴 확인
 * 4. 어떤 레벨에서든 가운데라면 공백 출력
 * 
 * 시간 복잡도: O(N²)
 * 공간 복잡도: O(log N) - 재귀 깊이
 * 
 * 핵심 개념:
 * - 프랙탈의 자기 유사성 (self-similarity)
 * - 재귀적 패턴 인식
 * - 좌표 기반 조건 판별
 */

import java.util.Scanner;

public class Main {

	static String star3 = "***";       // 3개 별 패턴
	static String starWithSpace = "* *"; // 별-공백-별 패턴  
	static String spaces3 = "   ";      // 3개 공백 패턴
	static int baseUnit;               // 기본 단위 (N/3)
	static int totalSize;              // 전체 크기 N

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		totalSize = sc.nextInt();
		baseUnit = totalSize / 3;

		// 특수 케이스: 크기가 1인 경우
		if (totalSize == 1) {
			System.out.print("*");
			return;
		}

		// N×N 패턴을 3×3 기본 블록 단위로 출력
		for (int i = 0; i < baseUnit; i++) {
			// 각 기본 블록은 3행으로 구성:
			printRowPattern(baseUnit, i, star3);       // 상단: ***
			printRowPattern(baseUnit, i, starWithSpace); // 중간: * *
			printRowPattern(baseUnit, i, star3);       // 하단: ***
		}
	}

	/**
	 * 한 행의 패턴을 출력하는 함수
	 * @param unitCount 행당 블록 개수
	 * @param rowIndex 현재 행 인덱스  
	 * @param pattern 출력할 기본 패턴
	 */
	private static void printRowPattern(int unitCount, int rowIndex, String pattern) {
		for (int colIndex = 0; colIndex < unitCount; colIndex++) {
			// 현재 위치에서 별 패턴을 출력할지 판별
			if (shouldPrintStarPattern(unitCount, rowIndex, colIndex)) {
				System.out.print(pattern);
			} else {
				System.out.print(spaces3);  // 공백 패턴 출력
			}
		}
		System.out.println();
	}

	/**
	 * 재귀적으로 별 패턴을 출력할지 판별
	 * 시에르핀스키 카펫의 핵심 로직
	 * 
	 * @param currentUnit 현재 단위 크기
	 * @param row 행 위치
	 * @param col 열 위치
	 * @return 별 패턴을 출력해야 하면 true
	 */
	private static boolean shouldPrintStarPattern(int currentUnit, int row, int col) {
		// 모든 분할 레벨에서 가운데 위치 확인
		while (currentUnit > 1) {
			// 현재 레벨에서의 블록 크기 계산
			int blockSize = baseUnit / currentUnit;
			
			// 현재 레벨의 3×3 패턴에서 위치 계산
			int blockRow = (row / blockSize) % 3;
			int blockCol = (col / blockSize) % 3;
			
			// 가운데 위치 (1,1)인지 확인
			if (blockRow == 1 && blockCol == 1) {
				return false;  // 가운데는 공백
			}
			
			// 다음 세분화 레벨로 이동
			currentUnit = currentUnit / 3;
		}
		
		return true;  // 모든 레벨에서 가운데가 아니면 별 출력
	}
}

/*
 * 시에르핀스키 카펫 패턴 상세 분석:
 * 
 * 1. 패턴 예시 (N=9):
 *    *********
 *    * ** ** *
 *    *********
 *    ***   ***
 *    * *   * *
 *    ***   ***
 *    *********
 *    * ** ** *
 *    *********
 * 
 * 2. 핵심 알고리즘:
 *    - 각 좌표에서 모든 분할 레벨 확인
 *    - 어떤 레벨에서든 3×3 패턴의 가운데면 공백
 *    - 모든 레벨에서 가운데가 아니면 별
 * 
 * 3. 좌표 변환 이해:
 *    blockSize = baseUnit / currentUnit: 현재 레벨 블록 크기
 *    (position / blockSize) % 3: 3×3 패턴 내 위치
 * 
 * 4. 프랙탈 특성:
 *    - 자기 유사성: 작은 부분이 전체와 같은 구조
 *    - 무한 세분화 가능
 *    - 재귀적 정의로 간단히 표현
 * 
 * 5. 다른 구현 방법:
 * 
 * 완전 재귀 방식:
 * static void drawPattern(int n) {
 *     if (n == 1) {
 *         System.out.print("*");
 *         return;
 *     }
 *     
 *     int size = n / 3;
 *     for (int i = 0; i < 3; i++) {
 *         for (int j = 0; j < 3; j++) {
 *             if (i == 1 && j == 1) {
 *                 printSpaces(size);
 *             } else {
 *                 drawPattern(size);
 *             }
 *         }
 *         System.out.println();
 *     }
 * }
 * 
 * 관련 문제:
 * - 백준 11729: 하노이 탑 (재귀)
 * - 백준 1074: Z (분할정복)  
 * - 백준 2448: 별 찍기 - 11 (시에르핀스키 삼각형)
 * - 백준 1780: 종이의 개수 (분할정복)
 */