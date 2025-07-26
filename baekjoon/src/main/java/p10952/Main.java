package p10952;

import java.util.Scanner;

/**
 * 백준 10952 - A+B-5
 * 분류: 구현, 사칙연산
 * 
 * 핵심 포인트:
 * - 특정 조건(0 0)으로 입력 종료를 판단
 * - 무한 반복문과 조건 체크로 종료 처리
 * 
 * 시간복잡도: O(N) - N은 입력 줄의 개수
 * 공간복잡도: O(1)
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			// 0 0이 입력되면 종료
			if (a == 0 && b == 0) return;
			
			System.out.println(a + b);
		}
	}
}