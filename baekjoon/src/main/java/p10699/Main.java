package p10699;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 백준 10699 - 오늘 날짜
 * 분류: 구현
 * 
 * 핵심 개념:
 * - 현재 날짜를 YYYY-MM-DD 형식으로 출력하기
 * - Java 8의 LocalDate API 사용
 * 
 * 학습 포인트:
 * 1. LocalDate.now()로 현재 날짜 가져오기
 * 2. DateTimeFormatter를 사용한 날짜 포맷팅
 * 3. 패턴 문자열을 이용한 날짜 형식 지정
 * 
 * 날짜 패턴:
 * - YYYY: 4자리 연도
 * - MM: 2자리 월 (01-12)
 * - DD: 2자리 일 (01-31)
 * 
 * 시간복잡도: O(1) - 시스템 날짜 조회
 * 공간복잡도: O(1) - 추가 공간 사용 최소
 */
public class Main {
	public static void main(String[] args) {
		// 현재 날짜 가져오기
		LocalDate today = LocalDate.now();
		
		// 날짜 형식 지정 (YYYY-MM-DD)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		// 형식에 맞춰 출력
		System.out.println(today.format(formatter));
	}
}