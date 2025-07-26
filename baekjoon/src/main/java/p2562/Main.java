package p2562;

import java.util.Scanner;

/**
 * 백준 2562 - 최댓값
 * 분류: 구현, 배열
 * 
 * 핵심 포인트:
 * - 9개의 자연수 중 최댓값과 그 위치(몇 번째) 찾기
 * - 배열 저장 후 탐색하여 최댓값과 인덱스 추적
 * 
 * 시간복잡도: O(N) - N=9, 입력과 탐색 각각 O(9)
 * 공간복잡도: O(N) - 배열 저장
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] m = new int[9]; // 9개의 자연수 저장

		// 9개의 자연수 입력
		for (int i = 0; i < 9; i++) {
			m[i] = sc.nextInt();
		}

		int idx = 0; // 최댓값의 위치
		int max = 0; // 최댓값
		
		// 배열을 순회하며 최댓값과 그 위치 찾기
		for (int i = 0; i < 9; i++) {
			if (max < m[i]) {
				max = m[i];
				idx = i; // 0-based 인덱스
			}
		}

		System.out.println(max);       // 최댓값 출력
		System.out.println(idx + 1);   // 위치 출력 (1-based)
	}
}