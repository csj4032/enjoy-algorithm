package p10951;

import java.util.Scanner;

/**
 * 백준 10951 - A+B-4
 * 분류: 구현, 사칙연산
 * 
 * 핵심 포인트:
 * - 입력 개수가 정해지지 않은 경우의 처리
 * - hasNextInt()를 사용하여 EOF까지 입력 받기
 * 
 * 시간복잡도: O(N) - N은 입력 줄의 개수
 * 공간복잡도: O(1)
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력이 끝날 때까지 반복 (EOF 처리)
		while(sc.hasNextInt()) {
			System.out.println(sc.nextInt() + sc.nextInt());
		}
	}
}