package p10808;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * 제목: 알파벳 개수
 * 링크: https://www.acmicpc.net/problem/10808
 * 분류: 문자열, 배열
 * 
 * 핵심 아이디어:
 * - 주어진 문자열에서 알파벳 소문자 a~z 각각의 개수를 세는 문제
 * - 빈도수 배열(frequency array)을 사용하여 해결
 * 
 * 알고리즘 접근:
 * 1. 크기 26인 정수 배열 생성 (a~z 대응)
 * 2. 문자열의 각 문자를 순회하며 해당 알파벳의 카운트 증가
 * 3. 'a'의 ASCII 값(97)을 빼서 배열 인덱스로 변환
 * 
 * 학습 개념:
 * - 빈도수 배열 (Frequency Array)
 * - ASCII 코드 활용한 문자-숫자 변환
 * - 배열 초기화와 Stream API 활용
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();  // 입력 문자열
		char[] m = n.toCharArray();  // 문자 배열로 변환
		
		// 알파벳 개수를 저장할 배열 (a~z: 26개)
		Integer[] l = new Integer[26];
		Arrays.fill(l, 0);  // 모든 요소를 0으로 초기화
		
		// 각 문자의 개수 세기
		for (char i : m) {
			// 'a'의 ASCII 값(97)을 빼서 인덱스 계산
			// 'a' -> 0, 'b' -> 1, ..., 'z' -> 25
			l[i - 97] += 1;
		}

		// 결과 출력 (a부터 z까지 순서대로)
		System.out.println(Stream.of(l).map(String::valueOf).collect(joining(" ")));
	}
}
