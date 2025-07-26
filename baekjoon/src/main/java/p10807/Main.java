package p10807;

import java.util.Scanner;

/**
 * 백준 10807 - 개수 세기
 * 분류: 구현, 배열
 * 
 * 핵심 포인트:
 * - N개의 정수 중에서 특정값 v가 몇 개 있는지 카운트
 * - 배열 순회하며 조건 만족하는 요소 개수 세기
 * 
 * 시간복잡도: O(N) - 배열을 한 번 순회
 * 공간복잡도: O(N) - 배열 저장
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정수의 개수
		int[] m = new int[n];  // N개의 정수 저장 배열

		// N개의 정수 입력
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		int k = sc.nextInt(); // 찾을 정수 v
		int count = 0;        // v의 개수
		
		// 배열을 순회하며 v와 같은 값의 개수 세기
		for (int i = 0; i < n; i++) {
			if (m[i] == k) {
				count++;
			}
		}

		System.out.println(count);
	}
}