package p10818;

import java.util.Scanner;

/**
 * 백준 10818 - 최소, 최대
 * 분류: 구현, 수학
 * 
 * 핵심 포인트:
 * - N개의 정수 중 최대값과 최소값 찾기
 * - 초기값 설정과 비교를 통한 최대/최소값 갱신
 * 
 * 시간복잡도: O(N) - N개의 수를 한 번씩 확인
 * 공간복잡도: O(1)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정수의 개수
		
		// 최대/최소값 초기화 (문제 조건: -1,000,000 ≤ 정수 ≤ 1,000,000)
		int max = -1000000;
		int min = 1000000;
		
		// N개의 정수를 입력받으며 최대/최소값 갱신
		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();
			if (max < m) max = m; // 최대값 갱신
			if (min > m) min = m; // 최소값 갱신
		}
		
		System.out.println(min + " " + max);
	}
}