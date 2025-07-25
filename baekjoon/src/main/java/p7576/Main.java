package p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제목 : 토마토
 * 링크 : https://www.acmicpc.net/problem/7576
 * 분류 : BFS
 * 
 * 문제 해설:
 * - 창고에 보관된 토마토가 며칠 지나면 다 익는지 구하는 문제
 * - 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 없는 칸
 * - 익은 토마토는 상하좌우 인접한 익지 않은 토마토를 하루에 하나씩 익게 함
 * 
 * 해결 방법:
 * - 멀티 소스 BFS: 처음에 익은 토마토들을 모두 큐에 넣고 시작
 * - 각 토마토가 익는 시점(day)을 함께 저장하여 최종 일수 계산
 * - 모든 BFS가 끝난 후 익지 않은 토마토가 남아있으면 -1 출력
 * 
 * 시간복잡도: O(N*M) - 각 칸을 최대 한 번씩 방문
 */
public class Main {

	static int[][] graph;
	static Deque<Point> deque = new LinkedList<>();
	static int direction[][] = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	static int n;
	static int m;
	static int q = -1;
	static boolean f = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nn = br.readLine().split(" ");
		n = Integer.parseInt(nn[0]);  // 가로 길이 (열)
		m = Integer.parseInt(nn[1]);  // 세로 길이 (행)
		graph = new int[m][n];
		
		// 토마토 상태 입력받기
		for (int i = 0; i < m; i++) {
			String[] mm = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(mm[j]);
				// 처음부터 익은 토마토들을 큐에 추가 (멀티 소스 BFS)
				if (graph[i][j] == 1) {
					deque.push(new Point(i, j, 0));  // 0일차부터 시작
				}
			}
		}
		
		bfs();  // BFS 실행
		System.out.println(q);  // 결과 출력
	}

	/**
	 * 멀티 소스 BFS를 이용한 토마토 익히기
	 */
	private static void bfs() {
		while (!deque.isEmpty()) {
			Point p = deque.peek();  // 현재 처리할 토마토 위치와 날짜
			deque.pop();
			
			// 상하좌우 4방향으로 토마토 익히기
			for (int k = 0; k < 4; k++) {
				int[] d = direction[k];
				int y = p.y + d[0];  // 새로운 y 좌표
				int x = p.x + d[1];  // 새로운 x 좌표
				
				// 경계 검사 및 익지 않은 토마토(0)인지 확인
				if (y >= 0 && y < m && x >= 0 && x < n && graph[y][x] == 0) {
					Point pp = new Point(y, x, p.d + 1);  // 하루 뒤에 익음
					deque.addLast(pp);  // 큐에 추가
					graph[y][x] = 1;    // 익은 토마토로 변경 (중복 방지)
				}
			}
			q = p.d;  // 현재까지의 최대 일수 갱신
		}
		
		// 모든 BFS가 끝난 후 익지 않은 토마토가 있는지 확인
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 0) {  // 여전히 익지 않은 토마토가 있음
					f = true;
					break;
				}
			}
		}
		
		// 익지 않은 토마토가 남아있으면 -1 출력
		if (f) q = -1;
	}
}

/**
 * 토마토의 위치와 익은 날짜를 저장하는 클래스
 */
class Point {
	int y;  // 세로 좌표 (행)
	int x;  // 가로 좌표 (열)
	int d;  // 토마토가 익은 날짜

	public Point(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
}