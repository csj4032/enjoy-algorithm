package p1110;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목: 더하기 사이클
 * 링크: https://www.acmicpc.net/problem/1110
 * 분류: 수학, 구현, 사이클
 * 
 * 핵심 아이디어:
 * - 주어진 수에서 시작하여 특정 규칙을 반복 적용해 원래 수로 돌아오는 사이클 길이 구하기
 * - 규칙: 각 자리 수의 합을 구해서 주어진 수의 가장 오른쪽 자리 수와 구한 합의 가장 오른쪽 자리 수를 이어 붙인 수
 * - 예: 26 → 2+6=8 → 68 → 6+8=14 → 84 → 8+4=12 → 42 → 4+2=6 → 26 (4번 만에 원래 수로 복귀)
 * 
 * 알고리즘 접근:
 * 1. 입력 수가 한 자리면 앞에 0을 붙여 두 자리로 만듦
 * 2. 각 자리 수의 합을 구함
 * 3. 원래 수의 오른쪽 자리 + 합의 오른쪽 자리를 조합하여 새로운 수 생성
 * 4. 원래 수와 같아질 때까지 반복하며 횟수 카운트
 * 
 * 학습 개념:
 * - 사이클 검출 알고리즘
 * - 재귀함수를 이용한 반복 처리
 * - 문자열 포맷팅 (%02d)과 자리수 분리
 * - Stream API를 이용한 배열 연산
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 시작 수
		System.out.println(cycle(n, n, 0));  // 사이클 길이 출력
	}

	/**
	 * 더하기 사이클을 수행하는 재귀 메서드
	 * @param n 원래 수 (비교 기준)
	 * @param m 현재 수 (연산 대상)
	 * @param c 현재까지의 사이클 횟수
	 * @return 사이클이 완성되는 총 횟수
	 */
	private static int cycle(int n, int m, int c) {
		c++;  // 사이클 횟수 증가
		
		// 현재 수를 두 자리 문자열로 변환 후 각 자리 분리
		String str1[] = String.format("%02d", m).split("");
		
		// 각 자리 수의 합을 구하고 두 자리로 만든 후 분리
		String str2[] = String.format("%02d", Arrays.stream(str1).mapToInt(i -> Integer.valueOf(i)).sum()).split("");
		
		// 원래 수의 오른쪽 자리 + 합의 오른쪽 자리로 새로운 수 생성
		int k = Integer.parseInt(str1[1] + str2[1]);
		
		// 원래 수와 같아지면 사이클 완료
		if (n == k) return c;
		
		// 아니면 새로운 수로 다음 사이클 수행
		return cycle(n, k, c);
	}
}