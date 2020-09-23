package p19236;

import java.util.Scanner;

/**
 * 제목 : 청소년 상어
 * 링크 : https://www.acmicpc.net/problem/19236
 * 분류 : 구현, 시뮬레이션, 백트래킹
 * 기출 : 삼성 SW 역량 테스트 기출 문제
 */
public class Main {

	static int max;
	static Tuple[][] map = new Tuple[4][4];
	static int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = new int[]{0, -1, -1, -1, 0, 1, 1, 1};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				var number = sc.nextInt();
				var direct = sc.nextInt();
				var t = new Tuple(i, j, number, direct);
				map[i][j] = t;
			}
		}
		max = map[0][0].number;
		map[0][0].number = 0;
		var original = map[0][0];
		var shark = new Tuple(original.y, original.x, original.number, original.direct);
		backTracing(shark, copyMap(map), max);
		System.out.println(max);
	}

	private static void fishMove(Tuple[][] map) {
		for (int i = 1; i <= 16; i++) {
			outer:
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (map[j][k].number.equals(i)) {
						var origin = map[j][k];
						var ddy = 0;
						var ddx = 0;
						var ddd = 0;
						var dddd = 0;
						while (true) {
							dddd = (origin.direct - 1 + ddd) % 8;
							ddy = origin.y + directY(1, dddd);
							ddx = origin.x + directX(1, dddd);
							if (ddy >= 0 && ddy < 4 && ddx >= 0 && ddx < 4 && map[ddy][ddx].number != 0) {
								break;
							}
							ddd++;
						}
						var destination = map[ddy][ddx];
						map[j][k] = new Tuple(origin.y, origin.x, destination.number, destination.direct);
						map[ddy][ddx] = new Tuple(ddy, ddx, origin.number, dddd + 1);
						break outer;
					}
				}
			}
		}
	}

	private static void backTracing(Tuple shark, Tuple[][] map, int k) {
		max = Math.max(k, max);
		fishMove(map);
		for (int i = 1; i < 4; i++) {
			var ddy = shark.y + directY(i, shark.direct - 1);
			var ddx = shark.x + directX(i, shark.direct - 1);
			if (ddy >= 0 && ddy < 4 && ddx >= 0 && ddx < 4 && map[ddy][ddx].number != -1) {
				var copyMap = copyMap(map);
				var kk = copyMap[ddy][ddx].number;
				copyMap[shark.y][shark.x] = empty();
				copyMap[ddy][ddx].number = 0;
				var copyShark = new Tuple(ddy, ddx, 0, copyMap[ddy][ddx].direct);
				backTracing(copyShark, copyMap, k + kk);
			}
		}
	}

	private static Tuple[][] copyMap(Tuple[][] map) {
		var copyMap = new Tuple[4][4];
		for (int j = 0; j < 4; j++) {
			for (int l = 0; l < 4; l++) {
				var original = map[j][l];
				copyMap[j][l] = new Tuple(original.y, original.x, original.number, original.direct);
			}
		}
		return copyMap;
	}

	private static Tuple empty() {
		return new Tuple(-1, -1, -1, -1);
	}

	private static int directY(int section, int direct) {
		return section == 0 ? 0 : section * dy[direct];
	}

	private static int directX(int section, int direct) {
		return section == 0 ? 0 : section * dx[direct];
	}

	private static boolean goHome(Tuple shark, Tuple[][] map) {
		var ddy = shark.y + dy[shark.direct - 1];
		var ddx = shark.x + dx[shark.direct - 1];
		if (ddy < 0 || ddy >= 4 || ddx < 0 || ddx >= 4 || map[ddy][ddx].x == -1) {
			return true;
		}
		return false;
	}

	private static void display(Tuple[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j].number + ":" + map[i][j].direct + " ");
			}
			System.out.println();
		}
	}
}

class Tuple implements Comparable<Tuple> {
	Integer y;
	Integer x;
	Integer number;
	Integer direct;

	public Tuple(Integer y, Integer x, Integer number, Integer direct) {
		this.y = y;
		this.x = x;
		this.number = number;
		this.direct = direct;
	}

	@Override
	public String toString() {
		return "Tuple{" +
				"y=" + y +
				", x=" + x +
				", number=" + number +
				", direct=" + direct +
				'}';
	}

	@Override
	public int compareTo(Tuple o) {
		return this.number.compareTo(o.number);
	}
}