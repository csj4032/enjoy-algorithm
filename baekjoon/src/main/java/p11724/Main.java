package p11724;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 제목 : 연결 요소의 개수
 * 링크 : https://www.acmicpc.net/problem/11724
 * 분류 : 그래프 이론, 그래프 탐색, DFS, BFS
 * 
 * 문제 해설:
 * - 무방향 그래프에서 연결 요소(Connected Component)의 개수를 구하는 문제
 * - 연결 요소: 서로 연결된 정점들의 집합 (연결된 부분 그래프)
 * - 그래프가 여러 개의 분리된 부분으로 나뉘어 있을 때, 각 부분의 개수를 세는 문제
 * 
 * 해결 방법:
 * - DFS 또는 BFS를 이용하여 각 정점에서 시작해서 연결된 모든 정점 방문
 * - 방문하지 않은 정점에서 DFS를 시작할 때마다 새로운 연결 요소 발견
 * - Union-Find(분리 집합) 자료구조로도 해결 가능
 * 
 * 현재 구현의 특징:
 * - DFS로 각 정점이 속한 연결 요소의 루트를 rr 배열에 저장
 * - Stream API를 사용하여 고유한 루트의 개수를 계산
 * 
 * 시간복잡도: O(V+E) - V: 정점 수, E: 간선 수
 */
public class Main {

	static List<List<Integer>> graph = new ArrayList<>();  // 인접 리스트로 그래프 표현
	static boolean[] v;      // 방문 여부 체크
	static Integer[] rr;     // 각 정점이 속한 연결 요소의 루트

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();  // 정점의 개수
		var m = sc.nextInt();  // 간선의 개수
		
		v = new boolean[n];    // 방문 배열 초기화
		rr = new Integer[n];   // 루트 배열 초기화
		
		// 그래프 초기화 (인접 리스트)
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		
		// 간선 정보 입력받아 무방향 그래프 구성
		for (int i = 0; i < m; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			graph.get(a - 1).add(b);  // a → b 연결
			graph.get(b - 1).add(a);  // b → a 연결 (무방향 그래프)
		}
		
		// 모든 정점에 대해 DFS 실행 (방문하지 않은 정점에서만 새로운 연결 요소 탐색)
		for (int i = 0; i < n; i++) dfs(i + 1, i + 1);
		
		// 고유한 루트의 개수 = 연결 요소의 개수
		System.out.println(Stream.of(rr).collect(Collectors.groupingBy(e -> e.intValue())).keySet().size());
	}

	/**
	 * DFS를 이용하여 연결된 모든 정점에 같은 루트를 할당
	 * @param i 현재 정점 (1-indexed)
	 * @param r 현재 연결 요소의 루트
	 */
	private static void dfs(int i, int r) {
		if (v[i - 1]) return;  // 이미 방문한 정점이면 리턴
		
		v[i - 1] = true;       // 현재 정점 방문 처리
		var vec = graph.get(i - 1);  // 현재 정점과 연결된 정점들
		
		// 인접한 모든 정점들에 대해 재귀적으로 DFS 실행
		for (int j = 0; j < vec.size(); j++) {
			var t = vec.get(j);
			if (!v[t - 1]) dfs(t, r);  // 방문하지 않은 정점에 대해 DFS 계속
		}
		
		rr[i - 1] = r;  // 현재 정점의 루트를 r로 설정
	}
}