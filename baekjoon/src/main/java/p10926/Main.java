package p10926;

import java.util.Scanner;

/**
 * 백준 10926 - ??!
 * 분류: 구현
 * 
 * 핵심 개념:
 * - 입력받은 아이디에 "??!" 문자열을 붙여서 출력하기
 * - 문자열 연결(concatenation) 연산
 * 
 * 학습 포인트:
 * 1. Scanner를 이용한 문자열 입력
 * 2. 문자열 연결 연산자(+) 사용
 * 3. 기본적인 입출력 처리
 * 
 * 예시:
 * - 입력: "joonas" → 출력: "joonas??!"
 * - 입력: "baekjoon" → 출력: "baekjoon??!"
 * 
 * 시간복잡도: O(1) - 단순 문자열 연결
 * 공간복잡도: O(1) - 입력 문자열 저장
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 아이디 입력받기
		String id = sc.next();
		
		// 아이디에 "??!" 붙여서 출력
		System.out.println(id + "??!");
	}
}