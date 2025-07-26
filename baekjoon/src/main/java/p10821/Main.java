package p10821;

import java.util.Scanner;

/**
 * 제목: 정수의 개수
 * 링크: https://www.acmicpc.net/problem/10821
 * 분류: 문자열, 파싱
 * 
 * 핵심 아이디어:
 * - 콤마로 구분된 정수들이 주어질 때 정수의 개수를 구하는 문제
 * - 문자열을 콤마 기준으로 분할하여 개수 계산
 * 
 * 알고리즘 접근:
 * 1. 입력 문자열을 콤마(",")로 분할
 * 2. 분할된 배열의 길이가 곧 정수의 개수
 * 3. String.split() 메서드 활용
 * 
 * 학습 개념:
 * - 문자열 분할(String Split) 기법
 * - 구분자를 이용한 토큰화(Tokenization)
 * - 배열 길이를 이용한 개수 계산
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력 문자열을 콤마 기준으로 분할
		String[] s = sc.next().split(",");
		// 분할된 배열의 길이 = 정수의 개수
		System.out.println(s.length);
	}
}