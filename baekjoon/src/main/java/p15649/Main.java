package p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * 제목 : N과 M (1)
 * 링크 : https://www.acmicpc.net/problem/15649
 * 분류 : 조합(nCr), 순열(nPr), DFS, 백트래킹
 * 
 * 문제 해설:
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 모두 구하는 문제
 * - 순열(Permutation) 문제: nPm = n!/(n-m)!
 * - 백트래킹을 사용하여 모든 경우의 수를 탐색
 * 
 * 해결 방법:
 * - DFS + 백트래킹으로 구현
 * - swap을 이용한 순열 생성 방법 사용
 * - 재귀적으로 depth를 증가시키며 M개를 선택했을 때 결과 저장
 * 
 * 시간복잡도: O(nPm) = O(n!/(n-m)!)
 */
public class Main {

	static StringBuilder sb;
	private static final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
	private static final List<String> strings = new ArrayList<>();

	private static Logger log;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());  // 1부터 N까지
		int m = Integer.parseInt(st.nextToken());  // M개를 고름
		
		permutation(n, m, 0);  // 순열 생성 시작
		strings.sort(Comparator.naturalOrder());  // 사전순 정렬
		strings.forEach(System.out::println);     // 결과 출력
	}

	/**
	 * 백트래킹을 이용한 순열 생성
	 * @param n 1부터 N까지의 자연수
	 * @param m 선택할 개수
	 * @param depth 현재 선택한 개수 (재귀 깊이)
	 */
	private static void permutation(int n, int m, int depth) {
		// 기저 조건: M개를 모두 선택했으면 결과 저장
		if (depth == m) {
			strings.add(Arrays.stream(numbers).limit(m)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" ")));
			return;
		}
		
		// depth 위치부터 n까지 각각의 수를 depth 위치에 배치해보기
		for (int i = depth; i < n; i++) {
			swap(i, depth);           // i번째 수를 depth 위치로 이동
			permutation(n, m, depth + 1);  // 재귀 호출로 다음 위치 선택
			swap(i, depth);           // 백트래킹: 원래 상태로 복구
		}
	}

	/**
	 * 두 위치의 원소를 교환하는 함수
	 */
	private static void swap(int p, int q) {
		int t = numbers[p];
		numbers[p] = numbers[q];
		numbers[q] = t;
	}

	private static void combination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		if (r == 0) {
			for (int i = 0; i < index; i++) {
				System.out.print(arr[combArr[i]] + " ");
			}
			System.out.println();
		} else if (target == n) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, n, r - 1, index + 1, target + 1, arr);
			combination(combArr, n, r, index, target + 1, arr);
		}
	}
}