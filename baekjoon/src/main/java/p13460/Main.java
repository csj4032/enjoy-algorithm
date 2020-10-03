package p13460;

import java.util.Scanner;

public class Main {

	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static int n;
	static int m;
	static String[][] map;


	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String[n][m];
		for (int i = 0; i < n; i++) {
			var line = sc.next().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = line[j];
				if (map[i][j].equals("R")) {

				} else if (map[i][j].equals("B")) {

				} else if (map[i][j].equals("O")) {

				}
			}
		}
		bfs();
	}

	private static void bfs() {
		for (int i = 0; i < 4; i++) {

		}
	}
}

class Ball {
	int y;
	int x;
	String rb;

	public Ball(int y, int x, String rb) {
		this.y = y;
		this.x = x;
		this.rb = rb;
	}

	@Override
	public String toString() {
		return "Ball{" +
				"y=" + y +
				", x=" + x +
				", rb='" + rb + '\'' +
				'}';
	}
}