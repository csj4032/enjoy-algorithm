package p8393;

import java.util.Scanner;

/**
 * 백준 8393 - 합
 * 분류: 수학, 구현, 사칙연산
 * 
 * 핵심 개념:
 * - 1부터 n까지의 자연수의 합 구하기
 * - 예: n=3이면 1+2+3=6
 * 
 * 학습 포인트:
 * 1. 반복문을 이용한 누적 합계 계산
 * 2. 수학 공식 활용 (n×(n+1)÷2)
 * 3. 변수 초기화와 증감 연산
 * 
 * 두 가지 해결 방법:
 * - 방법1: 반복문으로 직접 계산 O(n)
 * - 방법2: 수학 공식 사용 O(1)
 * 
 * 시간복잡도: O(n) - 반복문 사용 시
 * 공간복잡도: O(1) - 추가 공간 사용 최소
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 마지막 숫자
		
		// 방법1: 반복문을 이용한 누적 합계
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i; // 1부터 n까지 차례로 더하기
		}
		
		System.out.println(sum);
		
		// 방법2: 수학 공식 사용 (더 효율적)
		// int result = n * (n + 1) / 2;
		// System.out.println(result);
	}
}