package p2292;

import java.util.Scanner;

/**
 * 제목: 벌집
 * 링크: https://www.acmicpc.net/problem/2292
 * 분류: 수학, 규칙 찾기
 * 
 * 핵심 아이디어:
 * - 육각형으로 이루어진 벌집에서 중앙(1번)에서 N번 방까지 가는 최단 경로 구하기
 * - 1번 방 주위에 6개, 그 다음 층에 12개, ..., k번째 층에 6*k개의 방이 있음
 * - 각 층에서 가장 마지막 방 번호: 1, 7, 19, 37, 61, ...
 * 
 * 알고리즘 접근:
 * 1. 각 층의 마지막 방 번호를 순차적으로 계산
 * 2. N이 어느 층에 속하는지 찾기
 * 3. 찾은 층의 번호가 최단 경로
 * 
 * 학습 개념:
 * - 수열의 패턴 인식과 규칙 찾기
 * - 누적 합과 반복 계산
 * - 기하학적 특성을 이용한 문제 해결
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 찾고자 하는 방 번호
		
		int m = 1;  // 현재 층 번호 (최단 경로)
		int j = 1;  // 현재 층의 마지막 방 번호
		int i = 1;  // 다음 층의 방 개수 계산용
		
		// N이 어느 층에 속하는지 찾기
		while (true) {
			if (n > j) {  // N이 현재 층의 마지막 방보다 크면
				m++;         // 다음 층으로 이동
				j = j + 6 * i;  // 다음 층의 마지막 방 번호 계산
				             // i번째 층에는 6*i개의 방이 있음
				i++;         // 다음 층 인덱스 증가
			} else {
				break;       // N이 현재 층에 속하므로 종료
			}
		}
		
		System.out.println(m);  // 최단 경로 출력
	}
}