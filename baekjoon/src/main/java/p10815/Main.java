package p10815;

/*
 * 백준 10815번: 숫자 카드
 * https://www.acmicpc.net/problem/10815
 * 
 * [문제 분류] 이분 탐색 (Binary Search) / 자료구조
 * [난이도] Silver 5
 * 
 * [문제 요약]
 * 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 
 * 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 500,000
 * - 1 ≤ M ≤ 500,000
 * - -10,000,000 ≤ 카드에 적혀있는 수 ≤ 10,000,000
 * 
 * [알고리즘 설명]
 * 1. 전형적인 존재 여부 판단 문제
 * 2. 현재 구현은 배열 인덱싱을 사용한 O(1) 접근법
 * 3. 수의 범위가 제한적(-10,000,000 ~ 10,000,000)이므로 배열로 직접 매핑 가능
 * 4. 음수 처리를 위해 오프셋(+10,000,000) 적용
 * 
 * [구현 방법]
 * - int[20,000,000] 배열 사용 (음수 ~양수 전체 범위 커버)
 * - 카드 존재 시 해당 인덱스에 1 표시
 * - 쿼리 시 해당 인덱스 값 출력 (1: 존재, 0: 미존재)
 * 
 * [다른 해결 방법들]
 * 1. 이분 탐색: 카드를 정렬 후 이분 탐색으로 존재 여부 확인 O(log n)
 * 2. HashSet: Set 자료구조로 존재 여부 확인 O(1) 평균
 * 3. HashMap: 현재 구현과 유사하지만 메모리 효율적
 * 
 * [이분 탐색 구현 예시]
 * Arrays.sort(cards);
 * for (query) {
 *     boolean found = Arrays.binarySearch(cards, query) >= 0;
 *     System.out.println(found ? 1 : 0);
 * }
 * 
 * [현재 구현의 장단점]
 * 장점: O(1) 시간 복잡도로 매우 빠름
 * 단점: 큰 메모리 사용량 (80MB), 수의 범위가 클 때 사용 불가
 * 
 * [시간복잡도] O(n + m) - 배열 방식
 * [공간복잡도] O(20,000,000) - 고정 배열 크기
 */

import java.util.Scanner;

public class Main {

	private static int[] k = new int[20000000];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			k[l + 10000000] = 1;  // 음수 처리를 위한 오프셋 적용
		}

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int l = sc.nextInt();
			System.out.print(k[l + 10000000]);  // O(1) 시간에 존재 여부 확인
			if (i != m - 1) System.out.print(" ");
		}
	}
}
