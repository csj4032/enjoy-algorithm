package p1065;

import java.util.Scanner;

/**
 * 백준 1065 - 한수
 * 분류: 브루트포스 알고리즘
 * 
 * 핵심 개념:
 * - 한수: 각 자릿수가 등차수열을 이루는 수
 * - 예: 123 (2-1 = 3-2 = 1), 135 (3-1 = 5-3 = 2)
 * - 1~99는 모두 한수, 100 이상부터 체크 필요
 * 
 * 학습 포인트:
 * 1. 숫자의 각 자릿수 분리하기
 * 2. 등차수열의 개념과 공차 계산
 * 3. 브루트포스를 통한 전체 탐색
 * 4. 함수 분리를 통한 코드 구조화
 * 
 * 시간복잡도: O(N) - N 이하의 모든 수 확인
 * 공간복잡도: O(1) - 추가 공간 사용 최소
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		// 1부터 N까지 모든 수를 확인
		for (int i = 1; i <= n; i++) {
			if (isHansu(i)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	/**
	 * 주어진 수가 한수인지 판단하는 함수
	 * @param num 확인할 수
	 * @return 한수이면 true, 아니면 false
	 */
	private static boolean isHansu(int num) {
		// 한 자리, 두 자리 수는 모두 한수
		if (num < 100) {
			return true;
		}
		
		// 세 자리 이상인 경우 등차수열 확인
		String str = String.valueOf(num);
		int[] digits = new int[str.length()];
		
		// 각 자릿수를 배열에 저장
		for (int i = 0; i < str.length(); i++) {
			digits[i] = str.charAt(i) - '0';
		}
		
		// 첫 번째와 두 번째 자릿수의 차이를 구함 (공차)
		int diff = digits[1] - digits[0];
		
		// 모든 인접한 자릿수들의 차이가 같은지 확인
		for (int i = 2; i < digits.length; i++) {
			if (digits[i] - digits[i-1] != diff) {
				return false; // 공차가 다르면 한수가 아님
			}
		}
		
		return true; // 모든 차이가 같으면 한수
	}
}