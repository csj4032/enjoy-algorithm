package p10570;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			var v = sc.nextInt();
			var f = new int[10001];
			for (int j = 0; j < v; j++) {
				var s = sc.nextInt();
				f[s]++;
			}
			var max = 0;
			var idx = 0;
			for (int j = 0; j < 10001; j++) {
				if (max < f[j]) {
					idx = j;
					max = f[j];
				}
			}
			sb.append(idx + "\n");
		}
		System.out.println(sb.toString());
	}
}