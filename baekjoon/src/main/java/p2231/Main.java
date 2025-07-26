package p2231;

import java.util.Scanner;

/**
 * 제목 : 분해합
 * 링크 : https://www.acmicpc.net/problem/2231
 * 분류 : 브루트포스 알고리즘
 * 
 * 문제 해설:
 * - 어떤 자연수 N의 분해합은 N과 N의 각 자릿수의 합
 * - 예: 245의 분해합 = 245 + 2 + 4 + 5 = 256
 * - 주어진 N에 대해 분해합이 N이 되는 가장 작은 생성자를 구하는 문제
 * 
 * 해결 방법:
 * - 1부터 N-1까지 모든 수를 확인하여 분해합이 N인 첫 번째 수를 찾기
 * - 브루트포스 방식으로 완전탐색
 * - 생성자가 없으면 0 출력
 * 
 * 시간복잡도: O(N × log N) - N개의 수를 확인하고 각각의 자릿수 계산
 * 공간복잡도: O(1)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 찾고자 하는 수
		int result = 0;       // 생성자 (없으면 0)
		
		// 1부터 N-1까지 모든 수를 확인
		for (int i = 1; i < n; i++) {
			if (n == getSum(i)) {  // i의 분해합이 n과 같으면
				result = i;        // 생성자 발견
				break;             // 가장 작은 생성자이므로 종료
			}
		}
		System.out.print(result);
	}

	/**
	 * 주어진 수의 분해합을 계산하는 함수
	 * @param i 분해합을 구할 수
	 * @return i + i의 각 자릿수의 합
	 */
	private static int getSum(int i) {
		int temp = i;
		int sum = i;  // 수 자체부터 시작
		
		// 각 자릿수를 더하기
		while (temp > 0) {
			sum += temp % 10;  // 마지막 자릿수 더하기
			temp = temp / 10;  // 마지막 자릿수 제거
		}
		return sum;
	}
}
