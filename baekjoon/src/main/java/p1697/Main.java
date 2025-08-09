package p1697;

/*
 * 백준 1697번: 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 * 
 * [문제 분류] BFS / 그래프 탐색 / 최단경로
 * [난이도] Silver 1
 * 
 * [문제 요약]
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
 * - 걷기: X-1 또는 X+1로 이동 (1초 소요)
 * - 순간이동: 2*X로 이동 (1초 소요)
 * 수빈이가 동생을 찾는 가장 빠른 시간을 구하시오.
 * 
 * [제약 조건]
 * - 0 ≤ N, K ≤ 100,000
 * - 수빈이와 동생의 위치는 0 이상 100,000 이하
 * 
 * [알고리즘 설명 - BFS 최단경로]
 * 1. 핵심 아이디어: 각 위치를 정점으로, 이동을 간선으로 하는 그래프
 * 2. 모든 이동이 1초로 동일하므로 BFS로 최단시간 탐색 가능
 * 3. 3가지 이동 방법: X-1, X+1, X*2
 * 4. 방문 체크로 중복 탐색 방지
 * 
 * [BFS 적용 이유]
 * - 모든 이동의 비용이 1로 동일 (단위 가중치)
 * - 최단경로 문제
 * - 레벨별 탐색으로 처음 도달한 순간이 최단시간
 * 
 * [구현 세부사항]
 * 1. 큐에 (현재위치, 소요시간) 저장
 * 2. 방문 배열로 중복 방문 방지
 * 3. 범위 체크: 0 ≤ 위치 ≤ 100,000
 * 4. 목표 위치 도달 시 시간 출력 후 종료
 * 
 * [경계 조건 처리]
 * 1. 범위 초과: 음수나 100,000 초과 위치
 * 2. 이미 방문한 위치
 * 3. 시작 위치와 목표 위치가 같은 경우 (0초)
 * 
 * [최적화 고려사항]
 * 1. 방문 배열 크기: 최대 200,000까지 설정 (순간이동으로 범위 초과 가능)
 * 2. 조기 종료: 목표에 도달하면 즉시 종료
 * 3. 범위 체크를 큐에 넣기 전에 수행
 * 
 * [현재 코드의 문제점과 개선사항]
 * 문제점:
 * 1. 범위 체크가 큐에서 빼낸 후에 수행됨 (비효율적)
 * 2. 목표 도달 체크 위치가 부적절함
 * 3. visitor 배열 크기가 200,000인데 범위 체크는 100,000까지만
 * 
 * 개선된 구현:
 * while (!queue.isEmpty()) {
 *     Tuple2 current = queue.poll();
 *     int pos = current.value;
 *     int time = current.time;
 *     
 *     if (pos == K) {
 *         System.out.println(time);
 *         return;
 *     }
 *     
 *     // 세 가지 이동 방법
 *     int[] next = {pos - 1, pos + 1, pos * 2};
 *     for (int nextPos : next) {
 *         if (nextPos >= 0 && nextPos <= 100000 && !visited[nextPos]) {
 *             visited[nextPos] = true;
 *             queue.offer(new Tuple2(nextPos, time + 1));
 *         }
 *     }
 * }
 * 
 * [유사 문제들]
 * - 숨바꼭질 2 (12851번): 최단시간과 방법의 수
 * - 숨바꼭질 3 (13549번): 순간이동이 0초 (다익스트라 or 0-1 BFS)
 * - 숨바꼭질 4 (13913번): 최단경로 출력
 * 
 * [코딩테스트 관점]
 * - BFS 기본 문제의 대표 사례
 * - 상태 공간 탐색 개념 이해
 * - 그래프 모델링 능력 검증
 * 
 * [실제 응용]
 * - 게임에서 캐릭터 이동 최적화
 * - 로봇 경로 계획
 * - 네트워크 라우팅
 * 
 * [시간복잡도] O(N) - 각 위치를 최대 한 번씩 방문
 * [공간복잡도] O(N) - 방문 배열과 큐 공간
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	private static LinkedList<Tuple2> queue = new LinkedList();
	private static boolean[] visitor;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		visitor = new boolean[200_000];
		queue.add(new Tuple2(n, 0));
		while (!queue.isEmpty()) {
			Tuple2 tuple2 = queue.poll();
			var v = tuple2.value;
			var t = tuple2.time + 1;
			if (v < 0 || v > 100_000) continue;
			if (visitor[v]) continue;
			visitor[v] = true;
			if (tuple2.value.equals(k)) {
				System.out.println(tuple2.time);
				break;
			}
			queue.add(new Tuple2(v - 1, t));
			queue.add(new Tuple2(v + 1, t));
			queue.add(new Tuple2(v * 2, t));
		}
	}
}

class Tuple2 implements Comparable<Tuple2> {

	Integer value;
	Integer time;

	public Tuple2(Integer value, Integer time) {
		this.value = value;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Tuple2{" + "value=" + value + ", time=" + time + '}';
	}

	@Override
	public int compareTo(Tuple2 o) {
		return this.time.compareTo(o.time);
	}
}
// 100000 1
// 1 100000