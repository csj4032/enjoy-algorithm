package p20057;

import java.util.Scanner;

/**
 * 제목 : 마법사 상어와 토네이도
 * 링크 : https://www.acmicpc.net/problem/20057
 * 분류 : 구현, 브루트포스 알고리즘, 시계 반시계 배열 회전
 */
public class Main {

	private static int[][] map;
	private static int n;
	private static int k;
	private static int cy;
	private static int cx;
	private static int len;
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		k = n * 2 - 1;
		cy = n / 2;
		cx = n / 2;
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		var s = 0;
		System.out.println(cy + " : " + cx);
		while (k-- > 0) {
			//display(map);
			move(map, ++s);
		}
	}

	private static void move(int[][] map, int step) {
		var ddy = dy[step % 4];
		var ddx = dx[step % 4];
		len = len + (step % 2);
		cy = cy + ddy * len;
		cx = cx + ddx * len;
		System.out.println(cy + " : " + cx);
	}

	private static void display(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
