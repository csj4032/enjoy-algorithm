package p3190;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 제목 : 뱀
 * 링크 : https://www.acmicpc.net/problem/3190
 * 분류 : 구현, 자료 구조, 시뮬레이션, 덱, 큐
 * 기출 : 삼성 SW 역량 테스트 기출 문제
 */
public class Main {

	static int n;
	static int k;
	static int l;
	static int[][] map;
	static Map<Integer, String> infos;
	static Deque<Snake> snakes = new LinkedList();
	static int[] dy = new int[]{-1, 0, 1, 0};
	static int[] dx = new int[]{0, 1, 0, -1};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][n];

		for (int i = 0; i < k; i++) {
			var r = sc.nextInt();
			var c = sc.nextInt();
			map[r - 1][c - 1] = 1;
		}

		l = sc.nextInt();
		infos = new HashMap();
		for (int i = 0; i < l; i++) infos.put(sc.nextInt(), sc.next());

		var second = 0;
		map[0][0] = 0;
		snakes.add(new Snake(0, 0, true));
		var direct = 1;
		while (true) {
			second++;
			var head = snakes.getFirst();
			var ndy = head.y + dy[direct];
			var ndx = head.x + dx[direct];
			var isSnake = isSnake(ndy, ndx);
			if (ndy < 0 || ndy >= n || ndx < 0 || ndx >= n || isSnake) break;

			if (ndy >= 0 && ndy < n && ndx >= 0 && ndx < n) {
				if (map[ndy][ndx] == 1) {
					map[ndy][ndx] = 0;
				} else {
					snakes.removeLast();
				}
				snakes.addFirst(new Snake(ndy, ndx, true));
			}
			if (infos.containsKey(second)) direct = getDirect(direct, infos.get(second));
		}
		System.out.println(second);
	}

	private static boolean isSnake(int ndy, int ndx) {
		var result = false;
		for (Snake snake : snakes) {
			if (snake.y == ndy && snake.x == ndx) {
				result = true;
				break;
			}
		}
		return result;
	}

	private static int getDirect(int curDirect, String nextDirect) {
		if (nextDirect.equals("D")) {
			return (curDirect + 1) % 4;
		} else {
			return (4 + curDirect - 1) % 4;
		}
	}

	private static void display(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		IntStream.of(1,2).boxed().collect(Collectors.partitioningBy(e-> e > 5));
		IntStream.of(1,2).mapToObj(new IntFunction<Object>() {

			@Override
			public Object apply(int value) {
				return value;
			}
		});
	}
}

class Snake {
	int y;
	int x;
	boolean isHead;

	public Snake(int y, int x, boolean isHead) {
		this.y = y;
		this.x = x;
		this.isHead = isHead;
	}

	@Override
	public String toString() {
		return "Snake{" + "y=" + y + ", x=" + x + ", isHead=" + isHead + '}';
	}
}