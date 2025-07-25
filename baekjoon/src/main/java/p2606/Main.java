package p2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제목 : 바이러스
 * 링크 : https://www.acmicpc.net/problem/2606
 * 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 * 
 * 문제 해설:
 * - 1번 컴퓨터가 바이러스에 걸렸을 때, 연결된 모든 컴퓨터로 바이러스가 퍼짐
 * - 1번 컴퓨터를 통해 바이러스가 감염되는 컴퓨터의 수를 구하는 문제
 * - 본질적으로 연결 그래프에서 1번 노드와 연결된 모든 노드를 찾는 문제
 * 
 * 해결 방법:
 * - DFS 또는 BFS를 사용하여 1번 컴퓨터부터 시작해서 연결된 모든 컴퓨터 탐색
 * - 인접 리스트를 사용한 그래프 표현 (메모리 효율적)
 * - 1번 컴퓨터는 제외하고 감염된 컴퓨터 수만 계산
 */
public class Main {

	private static List<List<Integer>> graph = new ArrayList();
	private static boolean[] virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());  // 컴퓨터의 수
		var m = Integer.parseInt(br.readLine());  // 연결 쌍의 수
		var k = 0;  // 감염된 컴퓨터 수를 셀 변수
		
		virus = new boolean[n];  // 바이러스 감염 여부 체크 (0-indexed)
		virus[0] = true;  // 1번 컴퓨터(index 0)는 이미 감염

		// 인접 리스트로 그래프 초기화
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		
		// 컴퓨터 간 연결 정보 입력 (양방향 그래프)
		for (int i = 0; i < m; i++) {
			var c = br.readLine().split(" ");
			var a = Integer.parseInt(c[0]) - 1;  // 1-indexed를 0-indexed로 변환
			var b = Integer.parseInt(c[1]) - 1;
			graph.get(a).add(b);  // a → b 연결
			graph.get(b).add(a);  // b → a 연결 (무방향 그래프)
		}

		dfs(0);  // 1번 컴퓨터(index 0)부터 DFS 시작

		// 1번 컴퓨터를 제외한 감염된 컴퓨터 수 계산
		for (int i = 1; i < n; i++) {
			if (virus[i]) k++;
		}

		System.out.println(k);
	}

	/**
	 * DFS를 이용한 바이러스 전파 시뮬레이션
	 * @param idx 현재 컴퓨터 인덱스
	 */
	private static void dfs(int idx) {
		// 현재 컴퓨터와 연결된 모든 컴퓨터들을 확인
		for (int i = 0; i < graph.get(idx).size(); i++) {
			var next = graph.get(idx).get(i);  // 연결된 다음 컴퓨터
			
			// 아직 감염되지 않은 컴퓨터라면
			if (!virus[next]) {
				virus[next] = true;  // 바이러스 감염 처리
				dfs(next);           // 해당 컴퓨터에서 재귀적으로 전파 계속
			}
		}
	}
}
