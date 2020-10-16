package p13460;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 제목 : 구슬 탈출 2
 * 링크 : https://www.acmicpc.net/problem/13460
 * 분류 : 구현, 그래프 이론, 그래프 탐색, 브루트포스 알고리즘, 너비 우선 탐색
 * 기출 : 삼성 SW 역량 테스트 기출 문제
 */
public class Main {

	static int n;
	static int m;
	static Integer count = Integer.MAX_VALUE;
	static boolean redFall;
	static boolean blueFall;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static int[] goal = new int[2];
	static String[][] map;
	static int[][][][] visitor;
	static LinkedList<Ball> queue = new LinkedList();

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String[n][m];
		visitor = new int[n][m][n][m];
		var ball = new Ball(n, m);
		for (int i = 0; i < n; i++) {
			var line = sc.next().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = line[j];
				if (map[i][j].equals("R")) {
					ball.ry = i;
					ball.rx = j;
				} else if (map[i][j].equals("B")) {
					ball.by = i;
					ball.bx = j;
				} else if (map[i][j].equals("O")) {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}
		ball.map = map;
		visitor[ball.ry][ball.rx][ball.by][ball.bx] = 1;
		queue.add(ball);
		bfs();
		if (!count.equals(Integer.MAX_VALUE)) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}

	private static void bfs() {
		outer:
		while (!queue.isEmpty()) {
			var original = queue.peek();
			queue.pop();
			if (original.count >= 10) break;
			for (int i = 0; i < 4; i++) {
				redFall = false;
				blueFall = false;
				var tempMap = copy(original.map);
				var next = new Ball(tempMap, original.ry, original.rx, original.by, original.bx, original.count + 1);
				move(i, next);
				if (visitor[next.ry][next.rx][next.by][next.bx] == 0) {
					visitor[next.ry][next.rx][next.by][next.bx] = 1;
					if (blueFall) continue;
					if (redFall) break outer;
					queue.addLast(next);
				}
			}
		}
	}

	private static void move(int direct, Ball ball) {
		var over = false;
		String[][] map = ball.map;
		while (true) {
			map[ball.ry][ball.rx] = ".";
			ball.ry += dy[direct];
			ball.rx += dx[direct];
			if (map[ball.ry][ball.rx].equals("#")) {
				ball.ry -= dy[direct];
				ball.rx -= dx[direct];
				map[ball.ry][ball.rx] = "R";
				break;
			}
			if ((ball.ry == ball.by && ball.rx == ball.bx)) over = true;
			if (ball.ry == goal[0] && ball.rx == goal[1]) {
				map[ball.ry][ball.rx] = "O";
				redFall = true;
				count = Math.min(ball.count, count);
				break;
			}
		}

		if ((ball.ry == ball.by && ball.rx == ball.bx)) {
			map[ball.ry][ball.rx] = "B";
			ball.ry -= dy[direct];
			ball.rx -= dx[direct];
			map[ball.ry][ball.rx] = "R";
		}

		while (true) {
			map[ball.by][ball.bx] = ".";
			ball.by += dy[direct];
			ball.bx += dx[direct];
			if (map[ball.by][ball.bx].equals("#")) {
				ball.by -= dy[direct];
				ball.bx -= dx[direct];
				map[ball.by][ball.bx] = "B";
				break;
			}

			if (ball.by == goal[0] && ball.bx == goal[1]) {
				map[ball.by][ball.bx] = "O";
				count = Integer.MAX_VALUE;
				blueFall = true;
				break;
			}
		}

		if ((ball.ry == ball.by && ball.rx == ball.bx)) {
			if (over) {
				ball.ry -= dy[direct];
				ball.rx -= dx[direct];
				map[ball.ry][ball.rx] = "R";
			} else {
				map[ball.by][ball.bx] = "R";
				ball.by -= dy[direct];
				ball.bx -= dx[direct];
				map[ball.by][ball.bx] = "B";
			}
		}
	}

	private static String[][] copy(String[][] map) {
		var tempMap = new String[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		return tempMap;
	}

}

class Ball {
	int ry;
	int rx;
	int by;
	int bx;
	int count = 0;
	String map[][];

	public Ball(int n, int m) {
		map = new String[n][m];
	}

	public Ball(String[][] map, int ry, int rx, int by, int bx, int count) {
		this.map = map;
		this.ry = ry;
		this.rx = rx;
		this.by = by;
		this.bx = bx;
		this.count = count;
	}
}

/*
5 7
#######
#...B##
#.#.R##
#O#.###
#######
 */