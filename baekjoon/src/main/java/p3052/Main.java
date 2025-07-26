package p3052;

import java.util.Scanner;

/**
 * 백준 3052 - 나머지
 * 분류: 수학, 구현, 사칙연산
 * 
 * 핵심 개념:
 * - 10개의 수를 42로 나눈 나머지 중 서로 다른 값의 개수 구하기
 * - 나머지는 0~41 범위이므로 boolean 배열로 존재 여부 체크
 * 
 * 학습 포인트:
 * 1. 나머지 연산의 특성 (% 연산자)
 * 2. boolean 배열을 이용한 중복 제거 기법
 * 3. 집합의 개념 (서로 다른 값의 개수)
 * 
 * 시간복잡도: O(1) - 고정된 10개 입력과 42개 확인
 * 공간복잡도: O(1) - 크기 42인 배열 사용
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 0~41 범위의 나머지 존재 여부를 체크할 배열
		boolean[] remainder = new boolean[42];
		
		// 10개의 수를 입력받아 나머지 계산
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			int mod = num % 42;  // 42로 나눈 나머지
			remainder[mod] = true; // 해당 나머지 존재 표시
		}
		
		// 서로 다른 나머지의 개수 세기
		int count = 0;
		for (int i = 0; i < 42; i++) {
			if (remainder[i]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}