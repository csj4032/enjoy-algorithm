/**
 * 백준 10173번: 니모를 찾아서
 * https://www.acmicpc.net/problem/10173
 * 
 * 문제 설명:
 * 여러 줄의 문자열이 주어질 때, 각 줄에 "nemo"라는 단어가 포함되어 있는지 확인하는 문제
 * 대소문자는 구분하지 않으며, "nemo"는 독립된 단어여야 함
 * "EOI"가 입력되면 프로그램 종료
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner, nextLine 사용)
 * - 무한 반복문과 종료 조건
 * - 정규표현식 (Regular Expression)
 * - 대소문자 변환 (toLowerCase)
 * - 단어 경계 검사 (\b)
 * 
 * 시간복잡도: O(m * n) - m은 입력 줄 수, n은 각 줄의 길이
 */
package p10173;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		
		// "EOI"가 입력될 때까지 반복
		while (true) {
			String line = sc.nextLine();
			if (line.equals("EOI")) break;  // 종료 조건
			findNemo(line);
		}
		sc.close();
	}

	// 주어진 문자열에서 "nemo" 단어를 찾는 함수
	private static void findNemo(String line) {
		// 정규표현식: 단어 경계(\b)를 사용하여 독립된 "nemo" 단어 검색
		Pattern pattern = Pattern.compile("^.*\\b(nemo)\\b.*$");
		Matcher matcher = pattern.matcher(line.toLowerCase());  // 대소문자 무시
		
		if (matcher.find()) {
			System.out.println("Found");    // "nemo" 발견
		} else {
			System.out.println("Missing");  // "nemo" 없음
		}
	}
}