package p10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 제목: 문자열 분석
 * 링크: https://www.acmicpc.net/problem/10820
 * 분류: 문자열, 정규표현식
 * 
 * 핵심 아이디어:
 * - 주어진 문자열에서 소문자, 대문자, 숫자, 공백의 개수를 각각 세는 문제
 * - 정규표현식을 사용하여 각 문자 타입별로 매칭하여 개수 계산
 * 
 * 알고리즘 접근:
 * 1. 각 문자 타입에 대한 정규표현식 패턴 생성
 * 2. BufferedReader로 여러 줄 입력 처리
 * 3. Matcher를 사용해 각 패턴의 매칭 개수 계산
 * 
 * 학습 개념:
 * - 정규표현식(Regular Expression) 사용법
 * - Pattern과 Matcher 클래스 활용
 * - 문자 분류와 카운팅 알고리즘
 * - 여러 줄 입력 처리 방법
 */
public class Main {

	public static void main(String[] args) throws IOException {

		// 각 문자 타입에 대한 정규표현식 패턴 정의
		Pattern p1 = Pattern.compile("([a-z])");  // 소문자
		Pattern p2 = Pattern.compile("([A-Z])");  // 대문자
		Pattern p3 = Pattern.compile("(\\d)");    // 숫자
		Pattern p4 = Pattern.compile("(\\s)");    // 공백

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		// 여러 줄 입력을 EOF까지 처리
		while ((line = br.readLine()) != null) {

			// 각 문자 타입별 카운터 초기화
			int c1 = 0;  // 소문자 개수
			int c2 = 0;  // 대문자 개수
			int c3 = 0;  // 숫자 개수
			int c4 = 0;  // 공백 개수

			// 각 패턴에 대한 Matcher 생성
			Matcher m1 = p1.matcher(line);
			Matcher m2 = p2.matcher(line);
			Matcher m3 = p3.matcher(line);
			Matcher m4 = p4.matcher(line);

			// 소문자 개수 세기
			while (m1.find()) {
				c1++;
			}
			// 대문자 개수 세기
			while (m2.find()) {
				c2++;
			}
			// 숫자 개수 세기
			while (m3.find()) {
				c3++;
			}
			// 공백 개수 세기
			while (m4.find()) {
				c4++;
			}

			// 결과 출력: 소문자 대문자 숫자 공백 순서
			System.out.println(c1 + " " + c2 + " " + c3 + " " + c4);
		}
	}
}