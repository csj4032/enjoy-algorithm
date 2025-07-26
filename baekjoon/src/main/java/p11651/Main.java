package p11651;

/**
 * 백준 11651번: 좌표 정렬하기 2
 * https://www.acmicpc.net/problem/11651
 * 
 * 문제 분류: 정렬
 * 난이도: Silver V
 * 
 * 핵심 알고리즘:
 * - 다중 조건 정렬 (Multi-key Sorting)
 * - 2차원 좌표 정렬 (y좌표 우선)
 * 
 * 문제 해결 접근법:
 * 1. y좌표를 기준으로 오름차순 정렬
 * 2. y좌표가 같으면 x좌표를 기준으로 오름차순 정렬
 * 3. Map을 사용하여 y좌표별로 x좌표들을 그룹화
 * 
 * 시간 복잡도: O(N log N)
 * 공간 복잡도: O(N)
 * 
 * 핵심 개념:
 * - 11650번과 동일한 로직이지만 정렬 우선순위가 바뀜
 * - y좌표 우선 정렬을 위한 데이터 구조 설계
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	// 좌표 범위가 -100,000 ~ 100,000이므로 offset 사용
	static final int OFFSET = 100000;
	static int[] visited = new int[200001];  // 해당 y좌표가 존재하는지 확인
	static Map<Integer, List<Integer>> coordinateMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 좌표 입력 및 그룹화
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// y좌표에 offset을 더해서 양수 인덱스로 변환
			int adjustedY = y + OFFSET;
			visited[adjustedY] = 1;
			
			// y좌표별로 x좌표들을 그룹화
			coordinateMap.computeIfAbsent(adjustedY, k -> new ArrayList<>()).add(x);
		}

		// y좌표 순으로 정렬하여 출력
		coordinateMap.keySet().stream()
			.sorted()  // y좌표 오름차순 정렬
			.forEach(adjustedY -> {
				// 같은 y좌표 내에서 x좌표 오름차순 정렬
				List<Integer> xCoordinates = coordinateMap.get(adjustedY).stream()
					.sorted()
					.collect(Collectors.toList());
					
				// 원래 y좌표로 복원하여 출력
				int originalY = adjustedY - OFFSET;
				xCoordinates.forEach(x -> 
					System.out.println(x + " " + originalY)
				);
			});
	}
	
	/*
	 * 더 간단한 해결 방법:
	 * 
	 * 1. Point 클래스를 사용한 방법:
	 * class Point {
	 *     int x, y;
	 *     Point(int x, int y) { this.x = x; this.y = y; }
	 * }
	 * 
	 * List<Point> points = new ArrayList<>();
	 * // ... 입력 처리 ...
	 * points.sort(Comparator.comparing((Point p) -> p.y)
	 *                       .thenComparing(p -> p.x));
	 * 
	 * 2. 배열을 사용한 방법:
	 * int[][] points = new int[n][2];
	 * // ... 입력 처리 ...
	 * Arrays.sort(points, (a, b) -> 
	 *     a[1] != b[1] ? Integer.compare(a[1], b[1])  // y좌표 우선
	 *                  : Integer.compare(a[0], b[0])); // x좌표 보조
	 * 
	 * 비교 분석:
	 * - 11650번: x좌표 우선 → y좌표 보조
	 * - 11651번: y좌표 우선 → x좌표 보조
	 * - 같은 알고리즘, 다른 정렬 기준
	 * 
	 * 관련 문제:
	 * - 백준 11650: 좌표 정렬하기 (x좌표 우선)
	 * - 백준 1181: 단어 정렬 (길이 우선, 사전순 보조)
	 * - 백준 10825: 국영수 (다중 조건 정렬)
	 */
}