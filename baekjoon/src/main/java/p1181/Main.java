package p1181;

/**
 * 백준 1181번: 단어 정렬
 * https://www.acmicpc.net/problem/1181
 * 
 * 문제 분류: 정렬, 문자열
 * 난이도: Silver V
 * 
 * 핵심 알고리즘:
 * - 사용자 정의 정렬 (Custom Sorting)
 * - Stream API를 활용한 함수형 프로그래밍
 * 
 * 문제 해결 접근법:
 * 1. 단어들을 입력받아 중복 제거
 * 2. 길이별로 그룹화
 * 3. 길이 순으로 정렬 후, 같은 길이 내에서 사전순 정렬
 * 
 * 시간 복잡도: O(N log N + M log M) 
 * - N: 전체 단어 개수, M: 각 길이별 단어 개수
 * 공간 복잡도: O(N)
 * 
 * 확장 개념:
 * - Comparator.comparing() 활용한 다중 조건 정렬
 * - TreeMap을 활용한 자동 정렬
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> words = new ArrayList<>();
		int n = sc.nextInt();
		
		// 단어 입력 받기
		for (int i = 0; i < n; i++) {
			words.add(sc.next());
		}
		
		// Stream API를 활용한 정렬 및 출력
		// 1. distinct(): 중복 단어 제거
		// 2. groupingBy(String::length): 길이별로 그룹화
		// 3. 길이 순으로 정렬하고, 각 그룹 내에서 사전순 정렬
		Map<Integer, List<String>> lengthGroupedMap = words.stream()
			.distinct()  // 중복 제거
			.collect(Collectors.groupingBy(String::length));  // 길이별 그룹화
			
		// 길이 순으로 정렬하여 출력
		lengthGroupedMap.keySet().stream()
			.sorted()  // 길이 오름차순 정렬
			.forEach(length -> 
				lengthGroupedMap.get(length).stream()
					.sorted()  // 같은 길이 내에서 사전순 정렬
					.forEach(System.out::println)
			);
	}
	
	/*
	 * 다른 해결 방법들:
	 * 
	 * 1. Comparator를 활용한 직접 정렬:
	 * words.stream().distinct()
	 *      .sorted(Comparator.comparing(String::length)
	 *                        .thenComparing(String::valueOf))
	 *      .forEach(System.out::println);
	 * 
	 * 2. TreeSet을 활용한 자동 정렬:
	 * Set<String> sortedWords = new TreeSet<>(
	 *     Comparator.comparing(String::length)
	 *               .thenComparing(String::valueOf));
	 * 
	 * 관련 문제:
	 * - 백준 10814: 나이순 정렬 (안정 정렬)
	 * - 백준 11656: 접미사 배열 (문자열 정렬)
	 */
}