/**
 * 백준 10102번: 개표
 * https://www.acmicpc.net/problem/10102
 * 
 * 문제 설명:
 * A와 B 후보에 대한 투표 결과가 문자열로 주어졌을 때,
 * 누가 더 많은 표를 얻었는지 판별하는 문제
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 문자열 처리
 * - Stream API와 groupingBy를 이용한 카운팅
 * - Map 자료구조 활용
 * - 조건문을 통한 결과 판별
 * 
 * 시간복잡도: O(n) - 문자열 길이만큼 순회
 */
package p10102;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();      // 투표 수 (사실상 사용하지 않음)
		String s = sc.next();      // 투표 결과 문자열 (A 또는 B들의 조합)
		
		// Stream API를 사용하여 각 문자의 개수를 카운팅
		// 문자열을 문자 단위로 분할하고, 각 문자별 개수를 Map으로 수집
		Map<String, Long> map = Arrays.stream(s.split(""))
				.collect(groupingBy(String::valueOf, counting()));
		
		// A와 B의 득표수를 비교하여 결과 출력
		if (map.getOrDefault("A", 0L) > map.getOrDefault("B", 0L)) {
			System.out.println("A");      // A가 더 많은 표
		} else if (map.getOrDefault("A", 0L) < map.getOrDefault("B", 0L)) {
			System.out.println("B");      // B가 더 많은 표
		} else {
			System.out.println("Tie");    // 동점
		}
	}
}
