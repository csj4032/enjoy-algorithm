package p17140;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	static int r;
	static int c;
	static int k;
	static int s;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();
		var l = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				l[i][j] = sc.nextInt();
			}
		}
		cal(l, s);
	}

	private static void cal(int[][] l, int s) {
		if (l.length >= r && l[0].length >= c && l[r - 1][c - 1] == k) {
			System.out.println(s);
			return;
		}
		if (s > 100) {
			System.out.println(-1);
			return;
		}
		var rr = 0;
		var cc = 0;
		var mm = 0;
		if (l.length >= l[0].length) {
			rr = l.length;
			cc = l[0].length;
			var rca = new int[101][101];
			for (int i = 0; i < rr; i++) {
				var arr = new int[101];
				for (int j = 0; j < cc; j++) {
					var v = l[i][j];
					if (v != 0) arr[v]++;
				}
				var kk = 0;
				for (int k = 1; k <= 101; k++) {
					for (int j = 0; j < arr.length; j++) {
						if (k == arr[j]) {
							rca[i][kk] = j;
							rca[i][kk + 1] = k;
							kk += 2;
						}
					}
				}
				mm = Math.max(kk, mm);
			}
			var rcaa = new int[rr][mm];
			for (int i = 0; i < rr; i++) {
				for (int j = 0; j < mm; j++) {
					rcaa[i][j] = rca[i][j];
				}
			}
			cal(rcaa, s + 1);
		} else {
			rr = l.length;
			cc = l[0].length;
			var rca = new int[101][101];
			for (int i = 0; i < cc; i++) {
				var arr = new int[101];
				for (int j = 0; j < rr; j++) {
					var v = l[j][i];
					if (v != 0) arr[v]++;
				}
				var kk = 0;
				for (int k = 1; k < 101; k++) {
					for (int j = 0; j < arr.length; j++) {
						if (k == arr[j]) {
							rca[kk][i] = j;
							rca[kk + 1][i] = k;
							kk += 2;
						}
					}
				}
				mm = Math.max(kk, mm);
			}
			var rcaa = new int[mm][cc];
			for (int i = 0; i < mm; i++) {
				for (int j = 0; j < cc; j++) {
					rcaa[i][j] = rca[i][j];
				}
			}
			cal(rcaa, s + 1);
		}
	}
}