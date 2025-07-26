package p10822;

import java.util.Scanner;

/**
 * 제목: 더하기
 * 링크: https://www.acmicpc.net/problem/10822
 * 분류: 문자열, 파싱, 수학
 * 
 * 핵심 아이디어:
 * - 콤마로 구분된 정수들의 합을 구하는 문제
 * - 문자열을 분할한 후 각 부분을 정수로 변환하여 합계 계산
 * 
 * 알고리즘 접근:
 * 1. 입력 문자열을 콤마로 분할
 * 2. 각 분할된 문자열을 정수로 변환
 * 3. 모든 정수를 더하여 합계 계산
 * 
 * 학습 개념:
 * - 문자열 파싱과 타입 변환
 * - String.split()과 Long.parseLong() 활용
 * - 누적 합계 계산 알고리즘
 */
public class Main {

	static long n = 0;  // 합계를 저장할 변수

	public static void main(String[] args) {
		// 입력 문자열을 콤마로 분할하여 숫자 배열 생성
		String[] numbers = new Scanner(System.in).nextLine().split(",");
		
		// 각 숫자를 정수로 변환하여 합계에 더함
		for (int i = 0; i < numbers.length; i++) {
			n += Long.parseLong(numbers[i]);  // 문자열을 long으로 변환
		}
		
		System.out.print(n);  // 최종 합계 출력
	}
}