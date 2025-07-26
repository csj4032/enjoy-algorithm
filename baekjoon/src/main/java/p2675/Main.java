package p2675;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 제목: 문자열 반복
 * 링크: https://www.acmicpc.net/problem/2675
 * 분류: 문자열, 구현
 * 
 * 핵심 아이디어:
 * - 주어진 문자열의 각 문자를 R번씩 반복하여 새로운 문자열 생성
 * - 예: "ABC"를 3번 반복 → "AAABBBCCC"
 * 
 * 알고리즘 접근:
 * 1. 각 테스트 케이스마다 반복 횟수 R과 문자열 S 입력
 * 2. 문자열 S의 각 문자를 R번씩 반복하여 결과 문자열 생성
 * 3. StringBuffer를 사용하여 효율적인 문자열 조작
 * 
 * 학습 개념:
 * - 중첩 반복문을 이용한 문자 반복
 * - StringBuffer를 이용한 효율적인 문자열 조작
 * - 문자열 분할과 문자별 처리
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();  // 테스트 케이스 개수
		List<String> list = new ArrayList<>();  // 결과 저장 리스트
		
		// T개의 테스트 케이스 처리
		for (int i = 0; i < t; i++) {
			int r = sc.nextInt();  // 반복 횟수
			String[] str = sc.next().split("");  // 문자열을 문자별로 분할
			StringBuffer sb = new StringBuffer();  // 결과 문자열 생성
			
			// 각 문자에 대해 R번 반복
			for (int j = 0; j < str.length; j++) {
				for (int k = 0; k < r; k++) {
					sb.append(str[j]);  // 현재 문자를 R번 추가
				}
			}
			
			list.add(sb.toString());  // 완성된 문자열을 리스트에 추가
		}

		// 모든 결과 출력
		list.forEach(System.out::println);
	}
}