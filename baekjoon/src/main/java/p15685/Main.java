package p15685;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

/**
 * 제목 : 드래곤 커브
 * 링크 : https://www.acmicpc.net/problem/15685
 * 분류 : 구현, 시뮬레이션
 */
public class Main {

	static int[][] map = new int[101][101];
	static int n;
	static int k;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			LinkedList<Integer> temp = new LinkedList<>();
			var x = sc.nextInt();
			var y = sc.nextInt();
			var d = sc.nextInt();
			var g = sc.nextInt();
			map[y][x] = 1;
			list.addFirst(d);
			while (g >= 0) {
				do {
					var dd = list.pop();
					if (dd == 0) {
						dd = 1;
						x++;
					} else if (dd == 1) {
						dd = 2;
						y--;
					} else if (dd == 2) {
						dd = 3;
						x--;
					} else if (dd == 3) {
						y++;
						dd = 0;
					}
					map[y][x] = 1;
					temp.add(dd);
				} while (!list.isEmpty());
				g--;
				for (Integer ddd : temp) list.addFirst(ddd);
			}
		}

		display(map);

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
					k++;
				}
			}
		}
		System.out.println(k);
	}

	private static void display(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
