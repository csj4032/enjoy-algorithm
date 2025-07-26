package p1284;

import java.util.Scanner;

/**
 * 제목: 집 주소
 * 링크: https://www.acmicpc.net/problem/1284
 * 분류: 수학, 구현
 * 
 * 핵심 아이디어:
 * - 집 번호를 표시하는데 필요한 총 넓이(폰트 크기)를 계산하는 문제
 * - 각 숫자의 폭: 1은 2, 0은 4, 나머지는 3
 * - 숫자 사이와 양끝에 각각 1씩 추가 공간
 * 
 * 알고리즘 접근:
 * 1. 입력이 "0"이면 종료
 * 2. 기본 넓이: 문자열 길이 + 1 (양끝 공백)
 * 3. 각 숫자에 따라 추가 넓이 계산
 * 4. 총 넓이 = 기본 넓이 + 각 숫자의 추가 넓이
 * 
 * 학습 개념:
 * - 문자열 순회와 문자 분류
 * - 조건분기를 이용한 값 매핑
 * - 무한 루프와 종료 조건 처리
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		
		// 종료 조건이 나올 때까지 반복
		while (true) {
			var n = sc.next();  // 집 번호 입력
			if (n.equals("0")) break;  // 종료 조건
			
			// 기본 넓이: 숫자 사이 공백(n-1개) + 양끝 공백(2개)
			var k = n.length() + 1;
			
			// 각 숫자에 따라 추가 넓이 계산
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) == '1') {
					k += 2;  // 숫자 1의 크기
				} else if (n.charAt(i) == '0') {
					k += 4;  // 숫자 0의 크기
				} else {
					k += 3;  // 나머지 숫자(2-9)의 크기
				}
			}
			
			sb.append(k + "\n");  // 결과 저장
		}
		
		System.out.println(sb.toString());  // 모든 결과 출력
	}
}