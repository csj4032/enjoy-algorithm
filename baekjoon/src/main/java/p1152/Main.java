package p1152;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 제목 : 단어의 개수
 * 링크 : https://www.acmicpc.net/problem/1152
 * 분류 : 문자열 처리 (String Processing)
 * 
 * 문제 해설:
 * - 영어 대소문자와 공백으로 이루어진 문자열에서 단어의 개수를 세는 문제
 * - 단어: 공백으로 구분되는 연속된 문자들
 * - 문자열의 앞과 뒤에 공백이 있을 수 있음
 * 
 * 핵심 아이디어:
 * - 공백을 기준으로 문자열을 분할한 후, 빈 문자열을 제외하고 개수를 센다
 * - Java Stream API를 활용한 함수형 프로그래밍 접근법 사용
 * 
 * 해결 방법:
 * 1. 입력 문자열을 공백(" ")으로 분할
 * 2. 분할된 배열에서 빈 문자열("")을 필터링
 * 3. 남은 요소들의 개수를 반환
 * 
 * 시간복잡도: O(N) - N은 문자열의 길이
 * 공간복잡도: O(W) - W는 단어의 개수 (split 배열 저장)
 * 
 * 다른 해결 방법:
 * 1. StringTokenizer 사용: new StringTokenizer(input).countTokens()
 * 2. trim() + split() 조합: input.trim().split("\\s+").length
 * 3. 직접 순회하며 공백 변화 감지
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 한 줄 전체를 입력받음 (공백 포함)
		String input = sc.nextLine();
		
		// Stream API를 사용한 단어 개수 계산
		// 1. 공백으로 문자열 분할
		// 2. 빈 문자열 필터링 (앞뒤 공백으로 인한 빈 문자열 제거)
		// 3. 남은 요소의 개수 반환
		long wordCount = Stream.of(input.split(" "))
			.filter(word -> !"".equals(word))  // 빈 문자열이 아닌 것만 필터링
			.count();
		
		System.out.println(wordCount);
	}
	
	// 대안 해결 방법들 (참고용)
	/*
	// 방법 1: StringTokenizer 사용 (가장 간단)
	private static int countWordsUsingTokenizer(String input) {
		StringTokenizer st = new StringTokenizer(input);
		return st.countTokens();
	}
	
	// 방법 2: trim() + split() 사용
	private static int countWordsUsingTrimSplit(String input) {
		if (input.trim().isEmpty()) return 0;
		return input.trim().split("\\s+").length;
	}
	
	// 방법 3: 직접 순회 (메모리 효율적)
	private static int countWordsManually(String input) {
		int count = 0;
		boolean inWord = false;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				if (!inWord) {
					count++;
					inWord = true;
				}
			} else {
				inWord = false;
			}
		}
		return count;
	}
	*/
}