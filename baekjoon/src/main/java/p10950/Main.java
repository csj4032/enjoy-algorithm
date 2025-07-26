package p10950;

import java.util.Scanner;

/**
 * 백준 10950 - A+B-3
 * 분류: 구현, 사칙연산
 * 
 * 핵심 포인트:
 * - 테스트케이스 개수만큼 반복하여 두 수의 합 출력
 * - 기본적인 반복문과 입출력 처리
 * 
 * 시간복잡도: O(T) - T는 테스트케이스 개수
 * 공간복잡도: O(1)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트케이스 개수 입력
		
		// T번 반복하여 각 줄의 두 수의 합을 출력
		for (int i = 0; i < t; i++) {
			System.out.println(sc.nextInt() + sc.nextInt());
		}
	}
}