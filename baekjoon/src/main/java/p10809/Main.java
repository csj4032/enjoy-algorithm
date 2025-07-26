package p10809;

import java.util.Scanner;

/**
 * 제목: 알파벳 찾기
 * 링크: https://www.acmicpc.net/problem/10809
 * 분류: 문자열, 구현
 * 
 * 핵심 아이디어:
 * - 주어진 문자열에서 알파벳 a~z가 처음 등장하는 위치를 찾는 문제
 * - 존재하지 않으면 -1을 출력
 * 
 * 알고리즘 접근:
 * 1. 알파벳 a부터 z까지 순회
 * 2. 각 알파벳에 대해 String.indexOf() 메서드로 첫 등장 위치 찾기
 * 3. indexOf()는 없으면 -1을 반환하므로 그대로 활용
 * 
 * 학습 개념:
 * - String.indexOf() 메서드 활용
 * - ASCII 코드를 이용한 알파벳 순회
 * - 문자열 검색 알고리즘의 기초
 */
public class Main {
	public static void main(String[] args) {
		String str = new Scanner(System.in).next();  // 입력 문자열
		StringBuffer sb = new StringBuffer();
		
		// ASCII 코드 97('a')부터 122('z')까지 순회
		for (int i = 97; i < 123; i++) {
			char c = (char) i;  // ASCII 코드를 문자로 변환
			// 해당 문자가 처음 등장하는 위치 찾기 (없으면 -1)
			sb.append(str.indexOf(String.valueOf(c)) + " ");
		}
		System.out.println(sb.toString().trim());  // 마지막 공백 제거 후 출력
	}
}