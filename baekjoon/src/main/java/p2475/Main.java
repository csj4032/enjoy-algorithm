/**
 * 백준 2475번: 검증수
 * https://www.acmicpc.net/problem/2475
 * 
 * 문제 설명:
 * 5개의 고유번호가 주어졌을 때, 각 숫자를 제곱한 후 모두 더한 값의 일의 자리를 구하는 문제
 * 검증수 = (각 숫자의 제곱의 합) % 10
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner, nextLine, split 사용)
 * - 문자열 분할과 숫자 변환
 * - 반복문을 이용한 누적 계산
 * - Math.pow를 이용한 거듭제곱
 * - 나머지 연산 (모듈로 연산)
 * - long 타입 (큰 수 처리)
 * 
 * 시간복잡도: O(n) - n은 입력 숫자 개수 (여기서는 5개로 고정)
 */
package p2475;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numbers = sc.nextLine().split(" ");  // 공백으로 분리하여 배열로 저장
		long total = 0;  // 제곱의 합을 저장할 변수 (long 타입으로 오버플로우 방지)
		
		// 각 숫자를 제곱하여 누적 합계 계산
		for (int i = 0; i < numbers.length; i++) {
			long num = Long.parseLong(numbers[i]);  // 문자열을 숫자로 변환
			total += Math.pow(num, 2);              // 제곱하여 합계에 추가
		}
		
		// 검증수 = 제곱의 합의 일의 자리 (나머지 연산)
		System.out.println(total % 10);
	}
}