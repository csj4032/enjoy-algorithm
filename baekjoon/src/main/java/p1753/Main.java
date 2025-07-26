package p1753;

import java.io.*;
import java.util.*;

/**
 * 제목 : 최단경로
 * 링크 : https://www.acmicpc.net/problem/1753
 * 분류 : 그래프 이론, 다익스트라
 * 
 * 문제 해설:
 * - 방향 그래프에서 주어진 시작점으로부터 다른 모든 정점으로의 최단 거리를 구하는 문제
 * - 가중치가 음수가 아닌 그래프에서 단일 시작점 최단 경로 문제
 * - 다익스트라(Dijkstra) 알고리즘의 대표적인 응용 문제
 * 
 * 다익스트라 알고리즘:
 * - 우선순위 큐(최소 힙)를 사용하여 구현
 * - 시작점에서 각 정점까지의 최단 거리를 점진적으로 확정
 * - 그리디 알고리즘의 특성: 매번 가장 가까운 정점을 선택
 * 
 * 시간복잡도: O((V+E)logV) - V: 정점 수, E: 간선 수
 * 공간복잡도: O(V+E)
 */
public class Main {

	static Queue<Tuple> queue = new PriorityQueue<>(2000001);
	static List<List<Tuple>> graph = new ArrayList<>(2000001);
	static int[] distance;
	static boolean[][] processed;
	static int max = 2000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력: 정점의 개수 V, 간선의 개수 E
		String[] nn = br.readLine().split(" ");
		int v = Integer.parseInt(nn[0]);
		int e = Integer.parseInt(nn[1]);
		int s = Integer.parseInt(br.readLine());  // 시작 정점
		
		// 초기화
		distance = new int[v + 1];               // 최단 거리 배열
		processed = new boolean[v + 1][11];      // 처리 여부 (사용되지 않음)
		
		// 거리 배열을 무한대로 초기화하고 그래프 초기화
		for (int i = 0; i <= v; i++) {
			distance[i] = max;  // 무한대로 초기화
			graph.add(new ArrayList<>());
		}
		
		// 간선 정보 입력받아 인접 리스트 구성
		for (int i = 0; i < e; i++) {
			String[] nnn = br.readLine().split(" ");
			var u = Integer.parseInt(nnn[0]);   // 시작 정점
			var vv = Integer.parseInt(nnn[1]);  // 끝 정점
			var w = Integer.parseInt(nnn[2]);   // 가중치
			graph.get(u).add(new Tuple(vv, w)); // 방향 그래프
		}
		
		// 다익스트라 알고리즘 실행
		dijkstra(s);

		// 결과 출력: 각 정점까지의 최단 거리
		for (int i = 1; i <= v; i++) {
			if (distance[i] == max) {
				bw.write("INF\n");  // 도달할 수 없는 경우
			} else {
				bw.write(distance[i] + "\n");
			}
		}
		bw.close();
	}

	/**
	 * 다익스트라 알고리즘 구현
	 * @param s 시작 정점
	 */
	private static void dijkstra(int s) {
		distance[s] = 0;                      // 시작 정점의 거리는 0
		queue.add(new Tuple(s, 0));           // 우선순위 큐에 시작 정점 추가
		
		while (!queue.isEmpty()) {
			var cur = queue.poll();           // 가장 가까운 정점 선택
			
			// 이미 처리된 정점이면 스킵 (중복 처리 방지)
			if (distance[cur.v] < cur.w) continue;
			
			// 현재 정점과 인접한 모든 정점들에 대해 거리 갱신
			for (Tuple next : graph.get(cur.v)) {
				int newDistance = distance[cur.v] + next.w;  // 새로운 경로의 거리
				
				// 더 짧은 경로를 발견했으면 갱신
				if (newDistance < distance[next.v]) {
					distance[next.v] = newDistance;
					queue.offer(new Tuple(next.v, distance[next.v]));  // 큐에 추가
				}
			}
		}
	}
}

/**
 * 정점과 가중치 정보를 저장하는 클래스
 * 우선순위 큐에서 가중치 기준으로 정렬하기 위해 Comparable 구현
 */
class Tuple implements Comparable<Tuple> {
	int v;  // 정점 번호
	int w;  // 가중치 (거리)

	public Tuple(int v, int w) {
		this.v = v;
		this.w = w;
	}

	/**
	 * 가중치를 기준으로 오름차순 정렬 (최소 힙)
	 */
	@Override
	public int compareTo(Tuple o) {
		return Integer.compare(this.w, o.w);
	}

	@Override
	public String toString() {
		return "Tuple{" + "v=" + v + ", w=" + w + '}';
	}
}