package p11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// brute-force
// 구간 합 구하기 5
public class Main {

	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ins = br.readLine().split(" ");
		int n = Integer.parseInt(ins[0]);
		int t = Integer.parseInt(ins[1]);
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int c = Integer.parseInt(row[j]);
				arr[i][j] = c;
			}
		}

		for (int i = 0; i < t; i++) {
			String[] position = br.readLine().split(" ");
			int x1 = Integer.parseInt(position[0]);
			int y1 = Integer.parseInt(position[1]);
			int x2 = Integer.parseInt(position[2]);
			int y2 = Integer.parseInt(position[3]);
			System.out.println(section(x1 - 1, y1 - 1, x2 - 1, y2 - 1));
		}
	}

	private static long section(int x1, int y1, int x2, int y2) {
		int r = 0;
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				r += arr[i][j];
			}
		}
		return r;
	}
}