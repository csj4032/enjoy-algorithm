package p11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 제목 : 트리의 부모 찾기
 * 링크 : https://www.acmicpc.net/problem/11725
 * 분류 : 트리, DFS, BFS, 그래프 탐색
 * 
 * === 문제 해설 ===
 * 무방향 그래프로 주어진 트리에서 루트를 1번 노드로 했을 때,
 * 각 노드의 부모 노드를 찾는 문제입니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) 트리의 성질:
 *    - N개의 노드를 가진 트리는 정확히 N-1개의 간선을 가짐
 *    - 임의의 두 노드 사이에는 유일한 경로가 존재
 *    - 사이클이 존재하지 않는 연결 그래프
 * 
 * 2) 루트 트리로의 변환:
 *    - 무방향 트리에서 임의의 노드를 루트로 선택
 *    - DFS/BFS를 통해 부모-자식 관계 설정
 *    - 방문 순서에 따라 트리 구조 결정
 * 
 * 3) 그래프 탐색의 활용:
 *    - DFS: 깊이 우선으로 트리 구조 파악
 *    - BFS: 레벨 순서로 부모 관계 설정
 *    - 방문 체크로 역방향 간선 방지
 * 
 * === 알고리즘 설계 ===
 * 1) 인접 리스트로 무방향 그래프 표현
 * 2) 루트 노드(1번)부터 DFS 시작
 * 3) 방문하지 않은 인접 노드를 자식으로 설정
 * 4) 재귀적으로 서브트리 탐색
 * 
 * === 구현 세부사항 ===
 * 1) 자료구조 선택:
 *    - List<List<Integer>>: 인접 리스트 표현
 *    - int[] parent: 각 노드의 부모 저장
 *    - boolean[] visitor: 방문 여부 체크
 * 
 * 2) DFS 구현:
 *    - 현재 노드의 모든 인접 노드 확인
 *    - 미방문 노드에 대해 부모 설정 후 재귀 호출
 *    - 0-based 인덱싱과 1-based 문제 번호 변환
 * 
 * === 최적화 기법 ===
 * 1) 메모리 최적화:
 *    - ArrayList 초기 용량 설정
 *    - 배열 크기를 정확히 N으로 설정
 * 
 * 2) I/O 최적화:
 *    - BufferedReader 사용으로 빠른 입력
 *    - split() 대신 StringTokenizer 사용 가능
 * 
 * 3) 탐색 최적화:
 *    - 루트 노드 방문 체크로 불필요한 탐색 방지
 *    - 인접 리스트의 순서 최적화 가능
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O(N) (각 노드와 간선을 한 번씩 방문)
 * - 공간복잡도: O(N) (인접 리스트 + 배열들)
 * - DFS 재귀 스택: O(H) (H: 트리의 높이)
 * - 최악의 경우 (편향 트리): O(N) 스택 공간
 * 
 * === 대안 해결법 ===
 * 1) BFS 구현:
 *    - 큐를 사용한 레벨 순서 탐색
 *    - 스택 오버플로우 위험 없음
 *    - 같은 시간복잡도 O(N)
 * 
 * 2) Union-Find (Disjoint Set):
 *    - 트리 구조 파악에 활용 가능
 *    - 부모 찾기에 특화된 자료구조
 * 
 * 3) 인접 행렬 사용:
 *    - 간선 수가 많을 때 고려
 *    - 현재 문제에서는 비효율적
 * 
 * === 트리 문제의 확장 ===
 * 1) 트리의 지름 구하기:
 *    - 두 번의 DFS로 가장 먼 노드 쌍 찾기
 * 
 * 2) LCA (Lowest Common Ancestor):
 *    - 두 노드의 공통 조상 찾기
 *    - 이진 리프팅, 세그먼트 트리 활용
 * 
 * 3) 트리 DP:
 *    - 서브트리 정보를 이용한 동적 계획법
 *    - 트리에서의 최적화 문제
 * 
 * === 실제 응용 분야 ===
 * - 조직도/계층 구조 관리
 * - 파일 시스템 디렉토리 구조
 * - 네트워크 라우팅 테이블
 * - 컴파일러의 파싱 트리
 */
public class Main {

	private static List<List<Integer>> graph = new ArrayList();
	private static int[] parent;
	private static boolean[] visitor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		parent = new int[n];
		visitor = new boolean[n];
		visitor[0] = true;

		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

		for (int i = 1; i <= n - 1; i++) {
			var c = br.readLine().split(" ");
			var a = Integer.parseInt(c[0]) - 1;
			var b = Integer.parseInt(c[1]) - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		dfs(0);
		for (int i = 1; i < n; i++) System.out.println(parent[i]);
	}

	private static void dfs(int idx) {
		for (int i = 0; i < graph.get(idx).size(); i++) {
			var next = graph.get(idx).get(i);
			if (!visitor[next]) {
				parent[next] = idx + 1;
				visitor[next] = true;
				dfs(next);
			}
		}
	}
}