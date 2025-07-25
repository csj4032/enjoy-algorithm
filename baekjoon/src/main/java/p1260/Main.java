package p1260;

import java.util.*;

/**
 * 제목 : DFS 와 BFS
 * 링크 : https://www.acmicpc.net/problem/1260
 * 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 * 
 * 문제 해설:
 * - 주어진 그래프에서 DFS와 BFS 탐색 결과를 출력하는 문제
 * - DFS(깊이 우선 탐색): 스택을 이용하거나 재귀로 구현, 더 깊이 들어갈 수 있을 때까지 탐색
 * - BFS(너비 우선 탐색): 큐를 이용하여 구현, 현재 깊이의 모든 노드를 먼저 탐색
 * 
 * 구현 특징:
 * - 인접 행렬(2차원 배열)을 사용한 그래프 표현
 * - 정점 번호가 작은 것부터 방문하도록 구현
 * - DFS는 스택 기반 iterative 방식으로 구현 (재귀 함수도 주석으로 포함)
 * - 각 탐색마다 방문 배열 초기화 필요
 */
public class Main {

	private static StringBuilder sf1;
	private static StringBuilder sf2;
	private static boolean graph[][];
	private static boolean visit[];
	private static boolean flag;
	private static int m;
	private static int n;
	private static int v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();  // 정점의 개수
		m = sc.nextInt();  // 간선의 개수
		v = sc.nextInt();  // 탐색을 시작할 정점 번호

		sf1 = new StringBuilder();  // DFS 결과 저장
		sf2 = new StringBuilder();  // BFS 결과 저장
		graph = new boolean[1001][1001];  // 인접 행렬로 그래프 표현
		visit = new boolean[1001];       // 방문 여부 체크

		// 간선 정보 입력받아 무방향 그래프 구성
		for (int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = graph[y][x] = true;  // 양방향 연결
		}

		// DFS 실행
		dfss(v);
		// BFS를 위해 방문 배열 초기화
		visit = new boolean[1001];
		// BFS 실행
		bfs(v);
		
		// 결과 출력
		System.out.println(sf1.toString().trim());
		System.out.print(sf2.toString().trim());
	}

	/**
	 * DFS - 재귀 방식 (현재 사용되지 않음)
	 */
	private static void dfsr(int v) {
		visit[v] = true;
		sf1.append(v + " ");
		for (int i = 1; i <= n; i++) {
			if (graph[v][i] == true && visit[i] == false) {
				dfsr(i);
			}
		}
	}

	/**
	 * DFS - 스택을 이용한 반복문 방식
	 * @param v 시작 정점
	 */
	private static void dfss(int v) {
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		visit[v] = true;
		sf1.append(v + " ");
		
		while (!stack.isEmpty()) {
			flag = false;
			int x = stack.peek();  // 스택의 맨 위 원소 확인
			
			// 현재 정점과 연결된 정점들을 번호 순으로 탐색
			for (int i = 1; i <= n; i++) {
				if (graph[x][i] == true && visit[i] == false) {
					stack.push(i);    // 스택에 추가
					visit[i] = true;   // 방문 처리
					flag = true;
					sf1.append(i + " ");
					break;  // 하나 찾으면 더 깊이 들어가기
				}
			}
			
			// 더 이상 갈 곳이 없으면 스택에서 제거
			if (!flag) stack.pop();
		}
	}

	/**
	 * BFS - 큐를 이용한 너비 우선 탐색
	 * @param v 시작 정점
	 */
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visit[v] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.poll();  // 큐에서 하나 꺼내서 방문
			sf2.append(x + " ");
			
			// 현재 정점과 연결된 모든 정점들을 큐에 추가
			for (int i = 1; i <= n; i++) {
				if (graph[x][i] == true && visit[i] == false) {
					queue.offer(i);   // 큐에 추가
					visit[i] = true;  // 방문 처리 (중복 방지)
				}
			}
		}
	}
}