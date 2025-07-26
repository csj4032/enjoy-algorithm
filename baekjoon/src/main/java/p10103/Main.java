/**
 * 백준 10103번: 주사위 게임
 * https://www.acmicpc.net/problem/10103
 * 
 * 문제 설명:
 * 상근이와 창영이가 주사위 게임을 한다.
 * 각자 100점으로 시작하여, 주사위 눈이 작은 사람이 상대방의 주사위 눈만큼 점수를 잃는다.
 * 눈이 같으면 점수 변화 없음
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 반복문 (for문)
 * - 조건문 (if-else if)
 * - 전역 변수 사용
 * - 게임 시뮬레이션
 * 
 * 시간복잡도: O(n) - 게임 횟수만큼 반복
 */
package p10103;

import java.util.Scanner;

public class Main {

	static int SK = 100;  // 상근이의 초기 점수
	static int CY = 100;  // 창영이의 초기 점수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 게임 횟수

		// n번의 게임을 진행
		for (int i = 0; i < n; i++) {
			int sk = sc.nextInt();  // 상근이의 주사위 눈
			int cy = sc.nextInt();  // 창영이의 주사위 눈
			
			// 상근이의 눈이 작으면 상근이가 창영이의 주사위 눈만큼 점수 잃음
			if (sk < cy) {
				SK = SK - cy;
			} 
			// 창영이의 눈이 작으면 창영이가 상근이의 주사위 눈만큼 점수 잃음
			else if (sk > cy) {
				CY = CY - sk;
			}
			// sk == cy인 경우 점수 변화 없음
		}

		// 최종 점수 출력
		System.out.println(SK);   // 상근이의 최종 점수
		System.out.println(CY);   // 창영이의 최종 점수
	}
}