package p11720;

import java.util.Scanner;

/**
 * 백준 11720 - 숫자의 합
 * 분류: 구현, 문자열, 수학
 * 
 * 핵심 개념:
 * - N개의 숫자가 공백 없이 주어졌을 때, 각 숫자의 합을 구하기
 * - 문자열로 입력받아 각 문자를 숫자로 변환하여 합계 계산
 * 
 * 학습 포인트:
 * 1. 문자열의 각 문자를 순회하는 방법
 * 2. 문자를 숫자로 변환하는 방법 (문자 - '0')
 * 3. 누적 합계 계산
 * 
 * 시간복잡도: O(N) - N개의 문자를 순회
 * 공간복잡도: O(1) - 추가 공간 사용 최소
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();        // 숫자의 개수
		String numbers = sc.next();  // N개의 숫자가 붙어서 입력
		
		int sum = 0; // 합계를 저장할 변수
		
		// 문자열의 각 문자를 순회
		for (int i = 0; i < n; i++) {
			char digitChar = numbers.charAt(i);  // i번째 문자
			int digit = digitChar - '0';         // 문자를 숫자로 변환
			sum += digit;                        // 합계에 추가
		}
		
		System.out.println(sum);
	}
}