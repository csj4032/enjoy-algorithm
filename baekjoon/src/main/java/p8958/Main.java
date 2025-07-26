package p8958;

import java.util.Scanner;

/**
 * 백준 8958 - OX퀴즈
 * 분류: 구현, 문자열
 * 
 * 핵심 개념:
 * - OX퀴즈 점수 계산: 연속된 O의 개수만큼 점수가 누적됨
 * - 예: "OOXXOXXOOO" → 1+2+0+0+1+0+0+1+2+3 = 10점
 * 
 * 학습 포인트:
 * 1. 문자열 순회하며 연속된 패턴 처리
 * 2. 상태 추적 (연속된 O의 개수)
 * 3. 조건문을 통한 점수 계산 로직
 * 
 * 시간복잡도: O(L) - L은 문자열의 길이
 * 공간복잡도: O(1) - 추가 공간 사용 없음
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 테스트 케이스 개수
		
		for (int i = 0; i < n; i++) {
			String quiz = sc.next(); // OX퀴즈 결과 문자열
			int score = 0;           // 총 점수
			int consecutive = 0;     // 연속된 O의 개수
			
			// 문자열의 각 문자를 순회
			for (int j = 0; j < quiz.length(); j++) {
				char ch = quiz.charAt(j);
				
				if (ch == 'O') {
					// O인 경우: 연속 개수 증가하고 점수에 추가
					consecutive++;
					score += consecutive;
				} else {
					// X인 경우: 연속 개수 초기화
					consecutive = 0;
				}
			}
			
			System.out.println(score);
		}
	}
}