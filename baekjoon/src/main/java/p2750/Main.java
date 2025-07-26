package p2750;

/*
 * 백준 2750번: 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 * 
 * [문제 분류] 정렬
 * [난이도] Bronze 2
 * 
 * [문제 요약]
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 1,000
 * - 수는 절댓값이 1,000보다 작거나 같은 정수
 * - 수는 중복되지 않음
 * 
 * [알고리즘 설명]
 * 1. 기본 정렬 문제로, Java의 내장 정렬 함수를 사용하여 해결
 * 2. N이 작고(≤1,000) 시간제한이 넉넉하므로 O(n²) 정렬도 가능하지만,
 *    Stream API의 sorted()를 사용하여 O(n log n) 정렬 수행
 * 3. Arrays.sort()나 Collections.sort()도 동일한 시간복잡도로 사용 가능
 * 
 * [구현 방법]
 * - Stream.of(배열).sorted(): 배열을 스트림으로 변환 후 정렬
 * - 내부적으로 TimSort(Merge Sort + Insertion Sort 하이브리드) 사용
 * - 안정 정렬(Stable Sort)로 동일한 값의 순서 보장
 * 
 * [시간복잡도] O(n log n)
 * [공간복잡도] O(n)
 */

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] m = new Integer[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}
		Stream.of(m).sorted().forEach(e -> System.out.println(e));
	}
}