package p10871;

import java.util.Scanner;

/**
 * 백준 10871 - X보다 작은 수
 * 분류: 구현, 배열
 * 
 * 핵심 포인트:
 * - N개의 수 중에서 X보다 작은 수들을 순서대로 출력
 * - 조건 체크하며 즉시 출력하는 방식
 * 
 * 시간복잡도: O(N) - N개의 수를 한 번 확인
 * 공간복잡도: O(1) - 추가 배열 저장 없이 즉시 처리
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수의 개수
		int x = sc.nextInt(); // 기준값 X
		
		// N개의 수를 입력받으며 X보다 작은 수들을 즉시 출력
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (x > num) { // X보다 작은 경우
				System.out.print(num + " ");
			}
		}
	}
}
