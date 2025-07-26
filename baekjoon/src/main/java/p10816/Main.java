package p10816;

/*
 * 백준 10816번: 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 * 
 * [문제 분류] 이분 탐색 (Binary Search) / 자료구조
 * [난이도] Silver 4
 * 
 * [문제 요약]
 * 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 
 * 상근이가 가지고 있는 숫자 카드 중에서 각 수가 몇 개인지 구하는 프로그램을 작성하시오.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 500,000
 * - 1 ≤ M ≤ 500,000
 * - -10,000,000 ≤ 카드에 적혀있는 수 ≤ 10,000,000
 * 
 * [알고리즘 설명]
 * 1. 10815번(숫자 카드)의 확장 문제로, 존재 여부가 아닌 개수를 구해야 함
 * 2. 현재 구현은 HashMap을 사용한 계수(counting) 방식
 * 3. 각 숫자의 등장 횟수를 저장하여 O(1) 시간에 조회
 * 
 * [구현 방법]
 * - HashMap<Integer, Integer>로 (숫자, 개수) 매핑 저장
 * - 입력 시 해당 숫자의 개수 증가
 * - 쿼리 시 Map에서 개수 조회 (없으면 0 반환)
 * - BufferedReader + StringTokenizer로 빠른 입출력 처리
 * 
 * [다른 해결 방법들]
 * 1. 이분 탐색 (Upper bound - Lower bound):
 *    - 배열 정렬 후 각 숫자의 처음/마지막 위치 찾기
 *    - Collections.binarySearch() 활용
 * 2. 계수 정렬 (Counting Sort):
 *    - 범위가 제한적이므로 배열 인덱싱으로 개수 저장
 * 3. TreeMap: 정렬된 상태로 개수 관리
 * 
 * [이분 탐색 구현 예시]
 * Arrays.sort(cards);
 * for (query) {
 *     int lower = lowerBound(cards, query);
 *     int upper = upperBound(cards, query);
 *     System.out.println(upper - lower);
 * }
 * 
 * [HashMap의 장단점]
 * 장점: 
 * - 구현이 간단하고 직관적
 * - 평균 O(1) 시간 복잡도
 * - 수의 범위에 제약받지 않음
 * 단점:
 * - 해시 충돌 시 성능 저하 가능
 * - 추가 메모리 오버헤드
 * 
 * [최적화 포인트]
 * - BufferedReader로 입출력 속도 향상
 * - StringBuilder로 출력 성능 최적화
 * - getOrDefault() 메서드로 코드 간소화 가능
 * 
 * [시간복잡도] O(n + m) - HashMap 방식
 * [공간복잡도] O(n) - 서로 다른 숫자의 개수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] m = new int[n];
		
		// 각 숫자의 개수를 HashMap에 저장
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			m[i] = k;
			if (map.get(k) == null) {
				map.put(k, 1);
			} else {
				int v = map.get(k);
				map.put(k, v + 1);
			}
			// 위 코드는 map.put(k, map.getOrDefault(k, 0) + 1)로 간소화 가능
		}

		var l = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		var sb = new StringBuffer();
		
		// 각 쿼리에 대해 개수 조회
		for (int i = 0; i < l; i++) {
			int k = Integer.parseInt(st2.nextToken());
			if (map.get(k) == null) {
				sb.append(0);
			} else {
				sb.append(map.get(k));
			}
			sb.append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
