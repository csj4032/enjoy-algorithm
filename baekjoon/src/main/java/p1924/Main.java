package p1924;

import java.util.Scanner;

/**
 * 제목: 2007년
 * 링크: https://www.acmicpc.net/problem/1924
 * 분류: 수학, 구현
 * 
 * 핵심 아이디어:
 * - 2007년 1월 1일이 월요일이라 할 때, M월 D일이 무슨 요일인지 구하는 문제
 * - 2007년은 평년이므로 2월은 28일까지
 * - 요일 계산은 누적 일수를 7로 나눠 나머지로 결정
 * 
 * 알고리즘 접근:
 * 1. 각 달의 일수를 배열로 정의
 * 2. M월 D일까지의 총 일수 계산
 * 3. 총 일수를 7로 나눔 나머지로 요일 결정
 * 4. 1월 1일이 월요일(1)이므로 나머지 0은 일요일
 * 
 * 학습 개념:
 * - 날짜 계산과 모듈로 연산
 * - 배열을 이용한 데이터 매핑
 * - 누적 합과 순회 알고리즘
 */
public class Main {
	public static void main(String[] args) {
		// 요일 배열 (0: 일요일, 1: 월요일, ..., 6: 토요일)
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		// 2007년 각 달의 일수 (1월부터 12월까지)
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();  // 월
		int n = sc.nextInt();  // 일

		// M월 N일까지의 총 일수 계산
		int t = n;  // 해당 달의 일수

		// M월 이전 달들의 일수를 모두 더함
		for (int i = 1; i < m; i++) {
			t = t + months[i - 1];  // (i-1)월의 일수 추가
		}

		// 총 일수를 7로 나눔 나머지로 요일 결정
		// 1월 1일이 월요일(1)이므로 나머지 0은 일요일
		System.out.println(week[t % 7]);
	}
}
