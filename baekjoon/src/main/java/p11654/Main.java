package p11654;

import java.util.Scanner;

/**
 * 백준 11654 - 아스키 코드
 * 분류: 구현, 문자열
 * 
 * 핵심 개념:
 * - 문자를 아스키 코드 값으로 변환하기
 * - char 타입을 int로 변환하면 아스키 코드 값을 얻을 수 있음
 * 
 * 학습 포인트:
 * 1. 문자(char)와 아스키 코드의 관계
 * 2. 문자열에서 개별 문자 추출하기 (charAt 메서드)
 * 3. 데이터 타입 변환 (char → int)
 * 
 * 아스키 코드 참고:
 * - '0'~'9': 48~57
 * - 'A'~'Z': 65~90  
 * - 'a'~'z': 97~122
 * 
 * 시간복잡도: O(1) - 단일 문자 처리
 * 공간복잡도: O(1) - 추가 공간 사용 없음
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 한 글자 입력받기
		String input = sc.next();
		char ch = input.charAt(0);  // 첫 번째 문자 추출
		
		// char를 int로 변환하면 아스키 코드 값
		int asciiCode = (int) ch;
		
		System.out.println(asciiCode);
	}
}