package p7571;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var l = br.readLine().split(" ");
		var n = Integer.parseInt(l[0]);
		var m = Integer.parseInt(l[1]);
		var ys = new int[m];
		var xs = new int[m];

		for (int i = 0; i < m; i++) {
			var p = br.readLine().split(" ");
			var y = Integer.parseInt(p[0]);
			var x = Integer.parseInt(p[1]);
			ys[i] = y;
			xs[i] = x;
		}
		Arrays.sort(ys);
		Arrays.sort(xs);

		var c1 = ys[m / 2];
		var c2 = xs[m / 2];
		var p = 0l;

		for (int i = 0; i < m; i++) p = p + Math.abs(ys[i] - c1) + Math.abs(xs[i] - c2);

		System.out.println(p);
	}
}