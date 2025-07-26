package p5622;

import java.util.Scanner;

/**
 * 백준 5622 - 다이얼
 * 분류: 구현, 문자열
 * 
 * 핵심 개념:
 * - 전화기 다이얼에서 각 숫자를 누르는 데 필요한 시간 계산
 * - 각 알파벳이 어느 숫자에 해당하는지 매핑하여 시간 합계 구하기
 * 
 * 다이얼 매핑:
 * - 2: ABC (3초), 3: DEF (4초), 4: GHI (5초), 5: JKL (6초)
 * - 6: MNO (7초), 7: PQRS (8초), 8: TUV (9초), 9: WXYZ (10초)
 * 
 * 학습 포인트:
 * 1. 문자에 따른 조건 분기 처리
 * 2. 문자열의 각 문자를 순회하며 누적 계산
 * 3. switch문 또는 if문을 통한 매핑 처리
 * 
 * 시간복잡도: O(N) - N은 입력 문자열의 길이
 * 공간복잡도: O(1) - 추가 공간 사용 최소
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next(); // 입력 단어
		
		int totalTime = 0; // 총 시간
		
		// 문자열의 각 문자를 확인
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int time = getDialTime(ch); // 해당 문자의 다이얼 시간
			totalTime += time;
		}
		
		System.out.println(totalTime);
	}
	
	/**
	 * 주어진 문자가 다이얼에서 누르는 데 필요한 시간을 반환
	 * @param ch 확인할 문자
	 * @return 다이얼 시간 (초)
	 */
	private static int getDialTime(char ch) {
		// 각 숫자를 누르는 데 필요한 시간은 (숫자 + 1)초
		if (ch >= 'A' && ch <= 'C') return 3;      // 2번 (ABC)
		else if (ch >= 'D' && ch <= 'F') return 4; // 3번 (DEF)
		else if (ch >= 'G' && ch <= 'I') return 5; // 4번 (GHI)
		else if (ch >= 'J' && ch <= 'L') return 6; // 5번 (JKL)
		else if (ch >= 'M' && ch <= 'O') return 7; // 6번 (MNO)
		else if (ch >= 'P' && ch <= 'S') return 8; // 7번 (PQRS)
		else if (ch >= 'T' && ch <= 'V') return 9; // 8번 (TUV)
		else if (ch >= 'W' && ch <= 'Z') return 10; // 9번 (WXYZ)
		else return 0; // 해당 없음
	}
}