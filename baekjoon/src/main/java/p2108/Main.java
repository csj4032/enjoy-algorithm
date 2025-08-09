package p2108;

/*
 * 백준 2108번: 통계학
 * https://www.acmicpc.net/problem/2108
 * 
 * [문제 분류] 수학 / 구현 / 정렬
 * [난이도] Silver 3
 * 
 * [문제 요약]
 * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 문제
 * 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 때 가운데 위치하는 값
 * 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 500,000 (단, N은 홀수)
 * - -4000 ≤ 수 ≤ 4000
 * - 산술평균은 소수점 이하 첫째 자리에서 반올림
 * - 최빈값이 여러 개 있을 때는 두 번째로 작은 값을 출력
 * 
 * [알고리즘 설명]
 * 1. 산술평균: Stream.averagingInt() 사용하여 평균 계산 후 반올림
 * 2. 중앙값: 정렬 후 중간 인덱스(n/2) 값 추출
 * 3. 최빈값: Stream.groupingBy()로 빈도수 계산 후 최대 빈도 찾기
 * 4. 범위: Stream.max()와 Stream.min()으로 최댓값, 최솟값 계산
 * 
 * [구현 세부사항]
 * - Stream API를 적극 활용한 함수형 프로그래밍 스타일
 * - 최빈값 처리에서 동일한 빈도를 가진 값들 중 두 번째로 작은 값 선택
 * - System.out.format("%.0f%n", avg)로 반올림 출력 처리
 * 
 * [최빈값 처리 로직]
 * 1. groupingBy()로 각 수의 빈도수 계산
 * 2. max(Map.Entry.comparingByValue())로 최대 빈도 찾기
 * 3. 최대 빈도를 가진 모든 값들을 정렬된 리스트로 추출
 * 4. 크기가 2 이상이면 두 번째 원소(인덱스 1) 출력, 아니면 첫 번째 출력
 * 
 * [코드 분석 - 현재 구현의 문제점]
 * - 26번 줄: list2.size() > 2 조건이 잘못됨 (> 1이어야 함)
 * - 최빈값이 3개 이상일 때만 두 번째 값을 선택하는 버그
 * - 올바른 조건: if (list2.size() > 1)
 * 
 * [효율적인 대안 구현]
 * 1. 배열 기반 계수 정렬 (범위가 작으므로):
 *    int[] count = new int[8001]; // -4000~4000을 0~8000으로 매핑
 *    for (int num : numbers) count[num + 4000]++;
 * 
 * 2. Collections.frequency() 사용:
 *    최빈값 계산을 더 단순하게 처리
 * 
 * [시간복잡도] 
 * - 현재: O(n log n) - 정렬과 스트림 연산
 * - 최적화: O(n) - 계수 정렬 사용 시
 * 
 * [공간복잡도] O(n) - 리스트와 맵 저장
 * 
 * [주의사항]
 * - 반올림 처리 시 Math.round() 대신 format() 사용 권장
 * - 최빈값 여러 개일 때 정확한 두 번째 값 선택 로직 필요
 * - 입력 범위가 작으므로 계수 정렬이 더 효율적
 */

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		float avg = list.stream().collect(Collectors.averagingInt(Integer::valueOf)).floatValue();
		System.out.format("%.0f%n", avg);

		List<Integer> list1 = list.stream().sorted().collect(toList());
		System.out.println(list1.get(n / 2));

		Map<Integer, Long> map = list.stream().sorted().collect(groupingBy(Integer::valueOf, Collectors.counting()));
		Map.Entry entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		List<Integer> list2 = map.entrySet().stream().filter(e -> e.getValue().equals(entry.getValue())).map(e -> e.getKey()).sorted().collect(toList());
		if (list2.size() > 2) {
			System.out.println(list2.get(1));
		} else {
			System.out.println(entry.getKey());
		}

		System.out.println(list.stream().max(Comparator.comparing(Integer::intValue)).get() - list.stream().min(Comparator.comparing(Integer::intValue)).get());
	}
}