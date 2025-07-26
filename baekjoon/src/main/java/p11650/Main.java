package p11650;

/**
 * 백준 11650번: 좌표 정렬하기
 * https://www.acmicpc.net/problem/11650
 * 
 * 문제 분류: 정렬
 * 난이도: Silver V
 * 
 * 핵심 알고리즘:
 * - 다중 조건 정렬 (Multi-key Sorting)
 * - 2차원 좌표 정렬
 * 
 * 문제 해결 접근법:
 * 1. x좌표를 기준으로 오름차순 정렬
 * 2. x좌표가 같으면 y좌표를 기준으로 오름차순 정렬
 * 3. Map을 사용하여 x좌표별로 y좌표들을 그룹화
 * 
 * 시간 복잡도: O(N log N)
 * 공간 복잡도: O(N)
 * 
 * 핵심 개념:
 * - 좌표 압축을 통한 메모리 효율성 (offset +100000 사용)
 * - Stream API를 활용한 함수형 정렬
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	// 좌표 범위가 -100,000 ~ 100,000이므로 offset 사용
	static final int OFFSET = 100000;
	static int[] visited = new int[200001];  // 해당 x좌표가 존재하는지 확인
	static Map<Integer, List<Integer>> coordinateMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 좌표 입력 및 그룹화
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// x좌표에 offset을 더해서 양수 인덱스로 변환
			int adjustedX = x + OFFSET;
			visited[adjustedX] = 1;
			
			// x좌표별로 y좌표들을 그룹화
			coordinateMap.computeIfAbsent(adjustedX, k -> new ArrayList<>()).add(y);
		}

		// x좌표 순으로 정렬하여 출력
		coordinateMap.keySet().stream()
			.sorted()  // x좌표 오름차순 정렬
			.forEach(adjustedX -> {
				// 같은 x좌표 내에서 y좌표 오름차순 정렬
				List<Integer> yCoordinates = coordinateMap.get(adjustedX).stream()
					.sorted()
					.collect(Collectors.toList());
					
				// 원래 x좌표로 복원하여 출력
				int originalX = adjustedX - OFFSET;
				yCoordinates.forEach(y -> 
					System.out.println(originalX + " " + y)
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
	 * points.sort(Comparator.comparing((Point p) -> p.x)
	 *                       .thenComparing(p -> p.y));
	 * 
	 * 2. 배열을 사용한 방법:
	 * int[][] points = new int[n][2];
	 * // ... 입력 처리 ...
	 * Arrays.sort(points, (a, b) -> 
	 *     a[0] != b[0] ? Integer.compare(a[0], b[0]) 
	 *                  : Integer.compare(a[1], b[1]));
	 * 
	 * 관련 문제:
	 * - 백준 11651: 좌표 정렬하기 2 (y좌표 우선)
	 * - 백준 1181: 단어 정렬 (문자열 다중 조건 정렬)
	 * - 백준 10814: 나이순 정렬 (안정 정렬)
	 */
}