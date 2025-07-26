package p1316;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 제목: 그룹 단어 체커
 * 링크: https://www.acmicpc.net/problem/1316
 * 분류: 문자열, 구현
 * 
 * 핵심 아이디어:
 * - 그룹 단어란 각 문자가 연속해서 나타나는 단어
 * - 문자가 떨어져서 나타나면 그룹 단어가 아님
 * - 예: "aabbccdd" (O), "abcabc" (X - a, b, c가 떨어져서 나타남)
 * 
 * 알고리즘 접근:
 * 1. 각 단어에 대해 문자를 순회
 * 2. 현재 문자가 이전에 나타났고, 바로 이전 문자와 다르면 그룹 단어 아님
 * 3. 이미 나타난 문자들을 리스트로 관리
 * 
 * 학습 개념:
 * - 문자열 순회와 조건 검사
 * - List를 이용한 등장 문자 추적
 * - 연속성 체크 알고리즘
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 단어 개수
		int m = 0;  // 그룹 단어 개수
		
		// N개의 단어 검사
		for (int i = 0; i < n; i++) {
			String[] str = sc.next().split("");  // 문자열을 문자별로 분할
			List<String> list = new ArrayList<>();  // 등장한 문자들 저장
			list.add(str[0]);  // 첫 번째 문자 추가
			boolean flag = true;  // 그룹 단어 여부
			
			// 두 번째 문자부터 검사
			for (int j = 1; j < str.length; j++) {
				String now = str[j];    // 현재 문자
				String prev = str[j - 1];  // 이전 문자
				
				// 현재 문자가 이전에 나타났고, 바로 이전 문자와 다르면
				// 그룹 단어가 아님 (연속성이 깨짐)
				if (list.contains(now) && !now.equals(prev)) {
					flag = false;
					break;  // 더 이상 검사할 필요 없음
				} else {
					list.add(now);  // 새로운 문자이거나 연속된 문자
				}
			}
			
			if (flag) m++;  // 그룹 단어이면 카운트 증가
		}
		
		System.out.println(m);  // 그룹 단어 개수 출력
	}
}