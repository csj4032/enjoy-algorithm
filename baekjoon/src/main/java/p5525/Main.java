package p5525;

import java.util.Scanner;

/**
 * 제목 : IOIOI
 * 링크 : https://www.acmicpc.net/problem/5525
 * 분류 : 문자열 매칭 (String Matching) - KMP 알고리즘 적용 가능
 * 
 * 문제 해설:
 * - 주어진 문자열 S에서 특정 패턴 P(N)의 개수를 찾는 문제
 * - P(N) = "I" + "OI" * N (예: P(1) = "IOI", P(2) = "IOIOI", P(3) = "IOIOIOI")
 * - 문자열 S는 'I'와 'O'만으로 구성됨
 * 
 * 핵심 아이디어:
 * - 브루트 포스로 모든 위치에서 패턴 매칭을 확인
 * - KMP나 상태머신을 사용하면 더 효율적으로 해결 가능
 * 
 * 시간복잡도: O(M * N) - M은 문자열 길이, N은 패턴 길이
 * 공간복잡도: O(N) - 패턴 문자열 저장
 * 
 * 개선점:
 * 1. hashCode() 비교는 해시 충돌 가능성이 있어 위험함 - equals() 사용 권장
 * 2. 문자열 연결시 StringBuilder 사용으로 성능 개선 가능
 * 3. KMP 알고리즘 사용으로 O(M + N) 시간복잡도 달성 가능
 */
public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();      // 패턴의 길이 결정 변수
		var m = sc.nextInt();      // 입력 문자열의 길이
		var s = sc.next();         // 검색 대상 문자열
		
		// P(N) 패턴 생성: "I" + "OI" * N
		var pattern = generatePattern(n);
		var patternLength = pattern.length();
		
		// 가능한 모든 시작 위치의 개수
		var maxStartIndex = m - patternLength;
		var count = 0;
		
		// 브루트 포스로 패턴 매칭
		for (int i = 0; i <= maxStartIndex; i++) {
			// 주의: hashCode() 비교는 해시 충돌 위험이 있음
			// 더 안전한 방법은 s.substring(i, i + patternLength).equals(pattern) 사용
			if (s.substring(i, i + patternLength).hashCode() == pattern.hashCode()) {
				count++;
			}
		}
		
		System.out.println(count);
	}

	/**
	 * P(N) 패턴을 생성하는 메소드
	 * P(N) = "I" + ("OI" * N)
	 * 예: P(1) = "IOI", P(2) = "IOIOI"
	 * 
	 * 개선점: StringBuilder 사용으로 성능 향상 가능
	 */
	private static String generatePattern(int n) {
		var pattern = "";
		// "IO"를 N번 반복
		for (int i = 0; i < n; i++) {
			pattern += "IO";
		}
		// 마지막에 "I" 추가
		pattern += "I";
		return pattern;
	}
	
	// 더 효율적인 패턴 생성 방법 (개선안)
	/*
	private static String generatePatternOptimized(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("IO");
		}
		sb.append("I");
		return sb.toString();
	}
	*/
}
