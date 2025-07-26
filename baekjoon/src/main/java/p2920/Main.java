package p2920;

import java.util.Scanner;

/**
 * 백준 2920 - 음계
 * 분류: 구현
 * 
 * 핵심 개념:
 * - 8개의 숫자(1~8)가 오름차순, 내림차순, 혼합 중 어떤 상태인지 판별
 * - 오름차순: 1 2 3 4 5 6 7 8 → "ascending"
 * - 내림차순: 8 7 6 5 4 3 2 1 → "descending"  
 * - 그 외: "mixed"
 * 
 * 학습 포인트:
 * 1. 배열을 사용한 순차적 데이터 처리
 * 2. 문자열 비교를 통한 패턴 매칭
 * 3. 다중 조건문을 통한 분기 처리
 * 
 * 시간복잡도: O(1) - 고정된 8개 입력 처리
 * 공간복잡도: O(1) - 고정된 크기의 배열 사용
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 8개의 음을 저장할 배열
		int[] notes = new int[8];
		
		// 8개의 음 입력받기
		for (int i = 0; i < 8; i++) {
			notes[i] = sc.nextInt();
		}
		
		// 패턴 확인을 위해 입력을 문자열로 변환
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(notes[i]);
		}
		String sequence = sb.toString();
		
		// 패턴 판별
		if (sequence.equals("12345678")) {
			System.out.println("ascending");    // 오름차순 
		} else if (sequence.equals("87654321")) {
			System.out.println("descending");   // 내림차순
		} else {
			System.out.println("mixed");        // 혼합
		}
	}
}