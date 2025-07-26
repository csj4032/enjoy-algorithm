package p1920;

/*
 * 백준 1920번: 수 찾기
 * https://www.acmicpc.net/problem/1920
 * 
 * [문제 분류] 이분 탐색 (Binary Search) / 자료구조
 * [난이도] Silver 4
 * 
 * [문제 요약]
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 
 * 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 100,000
 * - 1 ≤ M ≤ 100,000
 * - -2^31 ≤ 정수 ≤ 2^31 (int 범위를 벗어날 수 있음)
 * 
 * [알고리즘 설명]
 * 1. 기본적인 존재 여부 탐색 문제
 * 2. 현재 구현은 HashMap + BigInteger를 사용한 방식
 * 3. BigInteger 사용 이유: 입력값이 int 범위를 벗어날 수 있기 때문
 * 4. 하지만 문제에서 주어진 범위는 실제로는 int 범위 내부
 * 
 * [구현 방법]
 * - HashMap<BigInteger, Integer>로 존재하는 수들을 저장
 * - containsKey()로 O(1) 평균 시간에 존재 여부 확인
 * - BigInteger 사용으로 범위 안전성 보장
 * 
 * [다른 해결 방법들]
 * 1. 이분 탐색 (표준 방법):
 *    Arrays.sort(arr);
 *    for (query) {
 *        boolean found = Arrays.binarySearch(arr, query) >= 0;
 *    }
 * 
 * 2. HashSet 사용 (더 적절한 자료구조):
 *    Set<Integer> set = new HashSet<>();
 *    set.contains(query);
 * 
 * 3. 직접 이분 탐색 구현:
 *    int binarySearch(int[] arr, int target) {
 *        int left = 0, right = arr.length - 1;
 *        while (left <= right) {
 *            int mid = (left + right) / 2;
 *            if (arr[mid] == target) return mid;
 *            else if (arr[mid] < target) left = mid + 1;
 *            else right = mid - 1;
 *        }
 *        return -1;
 *    }
 * 
 * [이분 탐색의 핵심 개념]
 * - 정렬된 배열에서 특정 값을 찾는 알고리즘
 * - 매번 탐색 범위를 절반으로 줄여나감
 * - 시간복잡도: O(log n)
 * - 전제조건: 배열이 정렬되어 있어야 함
 * 
 * [현재 구현의 특징]
 * 장점: 
 * - 매우 빠른 조회 속도 (평균 O(1))
 * - BigInteger로 범위 안전성 확보
 * 단점:
 * - 불필요한 BigInteger 사용으로 메모리/성능 오버헤드
 * - HashMap의 해시 계산 비용
 * 
 * [시간복잡도] O(n + m) - HashMap 방식
 * [공간복잡도] O(n) - 저장된 수의 개수
 */

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map<BigInteger, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// N개의 정수를 HashMap에 저장
		for (int i = 0; i < n; i++) {
			map.put(new BigInteger(sc.next()), 1);
		}

		int m = sc.nextInt();

		// M개의 쿼리에 대해 존재 여부 확인
		for (int i = 0; i < m; i++) {
			if (map.containsKey(new BigInteger(sc.next()))) {
				System.out.println(1);  // 존재함
			} else {
				System.out.println(0);  // 존재하지 않음
			}
		}
	}
}
