package p2583;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	private static int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static boolean[][] board;
	private static boolean[][] visitor;
	private static int m;
	private static int n;
	private static int t;
	private static int o;
	private static List<Integer> p = new ArrayList<>();

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		var k = sc.nextInt();
		board = new boolean[m][n];
		visitor = new boolean[m][n];
		for (int i = 0; i < k; i++) {
			var x1 = sc.nextInt();
			var y1 = sc.nextInt();
			var x2 = sc.nextInt();
			var y2 = sc.nextInt();

			for (int j = y1; j < y2; j++) {
				for (int l = x1; l < x2; l++) {
					board[j][l] = true;
					visitor[j][l] = true;
				}
			}
		}

		//display();

		for (int j = 0; j < m; j++) {
			for (int l = 0; l < n; l++) {
				t = 1;
				if (!board[j][l] && !visitor[j][l]) {
					o++;
					dfs(j, l);
					p.add(t);
				}
			}
		}
		System.out.println(o);
		System.out.println(p.stream().sorted().map(Object::toString).collect(Collectors.joining(" ")));
	}

	private static void dfs(int i, int j) {
		if (visitor[i][j]) {
			return;
		}
		visitor[i][j] = true;
		for (int k = 0; k < 4; k++) {
			var y = i + direct[k][0];
			var x = j + direct[k][1];
			if (0 <= y && y < m && 0 <= x && x < n && !visitor[y][x] && !board[y][x]) {
				t++;
				dfs(y, x);
			}
		}
	}

	private static void display() {
		for (int j = 0; j < m; j++) {
			for (int l = 0; l < n; l++) {
				System.out.print(board[j][l] + " ");
			}
			System.out.println();
		}
	}
}
