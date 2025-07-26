package p1373;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 제목: 2진수 8진수
 * 링크: https://www.acmicpc.net/problem/1373
 * 분류: 수학, 진법 변환
 * 
 * 핵심 아이디어:
 * - 2진수를 8진수로 변환하는 문제
 * - 2진수 3자리가 8진수 1자리에 대응됨
 * - 예: 111(2) = 7(8), 101(2) = 5(8), 1010(2) = 12(8)
 * 
 * 알고리즘 접근:
 * 1. 2진수 문자열을 오른쪽부터 3자리씩 그룹화
 * 2. 각 3자리 그룹을 해당하는 8진수 숫자로 변환
 * 3. HashMap을 사용하여 변환 테이블 구성
 * 4. 결과를 역순으로 출력
 * 
 * 학습 개념:
 * - 2진수와 8진수의 관계 (2^3 = 8)
 * - HashMap을 이용한 변환 테이블
 * - 문자열 분할과 substring 활용
 * - StringBuilder의 reverse() 메서드
 */
public class Main {

	// 2진수 3자리를 8진수 1자리로 변환하는 매핑 테이블
	static Map<String, String> m = new HashMap<>();

	static {
		// 1자리 또는 2자리 2진수 (앞에 0을 붙여 3자리로 만듦)
		m.put("0", "0");     // 0 -> 0
		m.put("000", "0");   // 000 -> 0
		m.put("001", "1");   // 001 -> 1
		m.put("1", "1");     // 1 -> 1
		m.put("010", "2");   // 010 -> 2
		m.put("10", "2");    // 10 -> 2
		m.put("011", "3");   // 011 -> 3
		m.put("11", "3");    // 11 -> 3
		m.put("100", "4");   // 100 -> 4
		m.put("101", "5");   // 101 -> 5
		m.put("110", "6");   // 110 -> 6
		m.put("111", "7");   // 111 -> 7
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.next();  // 2진수 문자열 입력
		int l = s.length();    // 2진수 문자열 길이
		
		// 3자리씩 그룹으로 나누었을 때의 그룹 수 (올림)
		int n = (int) Math.ceil((double) l / 3);
		
		// 오른쪽부터 3자리씩 처리
		for (int i = 0; i < n; i++) {
			// 현재 그룹의 시작 인덱스 계산
			int k = l - (3 * i) - 3;
			// 현재 그룹의 끝 인덱스 계산
			int t = l - (3 * i);
			
			// 시작 인덱스가 음수면 0으로 설정 (문자열 시작 부분)
			if (k < 0) k = 0;
			
			// 해당 그룹을 8진수로 변환하여 추가
			sb.append(m.get(s.substring(k, t)));
		}

		// 역순으로 출력 (왼쪽부터 오른쪽 순서로)
		System.out.println(sb.reverse().toString());
	}
}