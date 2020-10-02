package p19237;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 어른 상어
 * 링크 : https://www.acmicpc.net/problem/19237
 * 분류 : 구현, 시뮬레이션
 * 기출 : 삼성 SW 역량 테스트 기출 문제
 */
public class Main {

	static Shark[][] map;
	static Shark[] sharks;
	static int remainder;
	static int count;
	static int[] dy = new int[]{-1, 1, 0, 0};
	static int[] dx = new int[]{0, 0, -1, 1};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var k = sc.nextInt();
		map = new Shark[n][n];
		sharks = new Shark[m];
		remainder = m;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				var num = sc.nextInt();
				var shark = new Shark(0, i, j, 0);
				if (num != 0) {
					shark.num = num;
					shark.smell = k;
					shark.exist = true;
					sharks[num - 1] = shark;
				}
				map[i][j] = shark;
			}
		}

		for (int i = 0; i < m; i++) sharks[i].direct = sc.nextInt();

		for (int i = 0; i < m; i++) {
			var shark = sharks[i];
			for (int j = 0; j < 4; j++) {
				for (int l = 0; l < 4; l++) {
					shark.priority[j][l] = sc.nextInt();
				}
			}
		}

		while (true) {
			if (remainder == 1 || count > 1000) {
				break;
			}
			var originalMap = new Shark[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					var original = map[i][j];
					originalMap[i][j] = new Shark(original.num, original.y, original.x, original.smell, original.direct, original.priority, original.exist);
				}
			}
			var temp = new Shark[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					var original = map[i][j];
					var shark = new Shark(original.num, original.y, original.x, original.smell, original.direct, original.priority, original.exist);
					if (original.smell > 0) {
						original.smell--;
						if (original.smell == 0) original.num = 0;
					}
					if (shark.exist) {
						var isZero = false;
						var priority = shark.priority[shark.direct - 1];
						for (int l = 0; l < priority.length; l++) {
							var dyy = dy[priority[l] - 1] + shark.y;
							var dxx = dx[priority[l] - 1] + shark.x;
							if (dyy >= 0 && dyy < n && shark.x + dxx >= 0 && dxx < n && originalMap[dyy][dxx].smell == 0) {
								shark.direct = priority[l];
								shark.y = dyy;
								shark.x = dxx;
								if (temp[shark.y][shark.x] != null && temp[shark.y][shark.x].exist) {
									if (temp[shark.y][shark.x].num < shark.num) {
										shark.exist = false;
										shark = temp[shark.y][shark.x];
									} else {
										temp[shark.y][shark.x].exist = false;
										temp[shark.y][shark.x] = shark;
									}
									--remainder;
								}
								isZero = true;
								break;
							}
						}
						if (!isZero) {
							for (int l = 0; l < priority.length; l++) {
								var dyy = dy[priority[l] - 1] + shark.y;
								var dxx = dx[priority[l] - 1] + shark.x;
								if (dyy >= 0 && dyy < n && shark.x + dxx >= 0 && dxx < n && originalMap[dyy][dxx].num == shark.num) {
									shark.direct = priority[l];
									shark.y = dyy;
									shark.x = dxx;
									break;
								}
							}
						}
						original.exist = false;
						temp[shark.y][shark.x] = shark;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (temp[i][j] != null) map[i][j] = temp[i][j];
				}
			}
			count++;
		}

		if (count > 1000) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}
	}

	private static void display(Shark[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j].num + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Shark {
	int num;
	int y;
	int x;
	int smell;
	int direct;
	int priority[][] = new int[4][4];
	boolean exist = false;

	public Shark(int num, int y, int x, int smell) {
		this.num = num;
		this.y = y;
		this.x = x;
		this.smell = smell;
	}

	public Shark(int num, int y, int x, int smell, int direct, int[][] priority, boolean exist) {
		this.num = num;
		this.y = y;
		this.x = x;
		this.smell = smell;
		this.direct = direct;
		this.priority = priority;
		this.exist = exist;
	}

	@Override
	public String toString() {
		return "Shark{" +
				"num=" + num +
				", y=" + y +
				", x=" + x +
				", smell=" + smell +
				", direct=" + direct +
				", priority=" + Arrays.deepToString(priority) +
				", exist=" + exist +
				'}';
	}
}