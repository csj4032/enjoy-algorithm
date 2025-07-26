/**
 * 백준 2884번: 알람 시계
 * https://www.acmicpc.net/problem/2884
 * 
 * 문제 설명:
 * 현재 시각에서 45분 전의 시각을 구하는 문제
 * 0시 이전으로 넘어가는 경우 전날 23시대로 계산해야 함
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 시간 계산 (분 단위로 변환)
 * - 조건문 (음수 처리)
 * - 시간과 분으로 다시 변환
 * - 24시간 체계에서의 시간 계산
 * 
 * 시간복잡도: O(1) - 단순 계산
 */
package p2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();  // 시 입력
		int m = sc.nextInt();  // 분 입력
		
		// 현재 시각을 분 단위로 변환하고 45분을 뺌
		int t = (h * 60) + m - 45;
		
		// 음수가 되면 (0시 이전) 전날 시간으로 조정
		if (t < 0) {
			t = (24 * 60) + t;  // 하루(1440분)를 더해서 양수로 만듦
		}
		
		// 분을 다시 시와 분으로 분리하여 출력
		// (t - (t % 60)) / 60: 시간 부분
		// t % 60: 분 부분
		System.out.println((t - (t % 60)) / 60 % 24 + " " + t % 60);
	}
}