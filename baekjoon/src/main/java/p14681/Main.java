/**
 * 백준 14681번: 사분면 고르기
 * https://www.acmicpc.net/problem/14681
 * 
 * 문제 설명:
 * 점 (x, y)가 주어졌을 때, 이 점이 어느 사분면에 속하는지 구하는 문제
 * 1사분면: x > 0, y > 0
 * 2사분면: x < 0, y > 0
 * 3사분면: x < 0, y < 0
 * 4사분면: x > 0, y < 0
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 조건문 (if-else if)
 * - 논리 연산자 (&&)
 * - 좌표평면과 사분면의 개념
 * - var 키워드 (타입 추론)
 * 
 * 시간복잡도: O(1) - 단순 조건 확인
 */
package p14681;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var x = sc.nextInt();  // x 좌표 입력
		var y = sc.nextInt();  // y 좌표 입력
		var q = 0;             // 사분면 번호
		
		// 각 사분면 조건 확인
		if (x > 0 && y > 0) {        // 1사분면: x양수, y양수
			q = 1;
		} else if (x < 0 && y > 0) { // 2사분면: x음수, y양수
			q = 2;
		} else if (x < 0 && y < 0) { // 3사분면: x음수, y음수
			q = 3;
		} else if (x > 0 && y < 0) { // 4사분면: x양수, y음수
			q = 4;
		}
		
		System.out.println(q);
	}
}