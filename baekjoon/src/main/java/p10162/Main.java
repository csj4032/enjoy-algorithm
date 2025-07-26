/**
 * 백준 10162번: 전자레인지
 * https://www.acmicpc.net/problem/10162
 * 
 * 문제 설명:
 * 전자레인지에 A(5분=300초), B(1분=60초), C(10초) 버튼이 있다.
 * 주어진 시간 T초를 정확히 맞추기 위해 각 버튼을 최소 몇 번씩 눌러야 하는지 구하는 문제
 * 정확히 맞출 수 없으면 -1 출력
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 나눗셈과 나머지 연산
 * - 그리디 알고리즘 (큰 단위부터 처리)
 * - 조건문을 통한 예외 처리
 * - StringBuilder를 이용한 문자열 구성
 * 
 * 시간복잡도: O(1) - 단순 계산
 */
package p10162;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();  // 목표 시간 (초)
		var sb = new StringBuilder();
		
		// 10초 단위로 나누어떨어지지 않으면 정확히 맞출 수 없음
		if (t % 10 != 0) {
			System.out.println(-1);
		} else {
			// A버튼 (5분 = 300초) 사용 횟수
			sb.append(t / 300 + " ");
			t %= 300;  // 남은 시간
			
			// B버튼 (1분 = 60초) 사용 횟수
			sb.append(t / 60 + " ");
			t %= 60;   // 남은 시간
			
			// C버튼 (10초) 사용 횟수
			sb.append(t / 10);
		}
		System.out.println(sb.toString());
	}
}