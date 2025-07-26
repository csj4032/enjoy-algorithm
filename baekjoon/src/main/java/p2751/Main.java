package p2751;

/*
 * 백준 2751번: 수 정렬하기 2
 * https://www.acmicpc.net/problem/2751
 * 
 * [문제 분류] 정렬
 * [난이도] Silver 5
 * 
 * [문제 요약]
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 1,000,000
 * - 수는 절댓값이 1,000,000보다 작거나 같은 정수
 * - 수는 중복되지 않음
 * - 시간 제한: 2초
 * 
 * [알고리즘 설명]
 * 1. N이 최대 100만으로 크므로 O(n²) 정렬은 시간 초과 발생
 * 2. 수의 범위가 제한적(-1,000,000 ~ 1,000,000)이므로 계수 정렬(Counting Sort) 사용
 * 3. boolean 배열을 활용한 존재 여부 체크로 메모리 효율성 확보
 * 
 * [구현 방법]
 * - boolean[2,000,001] 배열 생성 (음수 처리를 위해 1,000,000 오프셋 추가)
 * - 입력된 수를 인덱스로 변환하여 존재 표시 (num + 1,000,000)
 * - 배열을 순회하며 존재하는 수들을 오름차순으로 출력
 * - StringBuilder 사용으로 출력 성능 최적화
 * 
 * [핵심 아이디어]
 * - 계수 정렬: 수의 범위가 제한적인 경우 O(n + k) 시간에 정렬 가능
 * - 음수 처리: 배열 인덱스는 음수가 될 수 없으므로 오프셋(+1,000,000) 적용
 * - 메모리 최적화: boolean 배열로 1bit당 1개 수 존재 여부 저장
 * 
 * [시간복잡도] O(n + k) where k = 2,000,001 (상수)
 * [공간복잡도] O(k) = O(2,000,001)
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] m = new boolean[2_000_001];
		for (int i = 0; i < n; i++) {
			m[sc.nextInt() + 1_000_000] = true;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 2_000_001; i++) {
			if (m[i]) {
				sb.append((i - 1000000) + "\n");
			}
		}

		System.out.print(sb.toString());
	}
}