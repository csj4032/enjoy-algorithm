package p4779;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean[] b = new boolean[550000];

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		var sc = new Scanner(System.in);
		while (sc.hasNext()) {
			var n = sc.nextInt();
			var m = Math.pow(3, n);
			Arrays.fill(b, false);
			cantor(n, 0, 0);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				if (b[i]) {
					sb.append(" ");
				} else {
					sb.append("-");
				}
			}
			bw.write(sb.toString());
			bw.write("\n");
			bw.flush();
		}
		bw.close();

	}

	private static void cantor(int n, int m, int k) {
		if (n <= 0 || m == 1) {
			if (m == 1) {
				for (int i = k; i < k + (int) Math.pow(3, n); i++) b[i] = true;
			}
			return;
		}
		for (int i = 0; i < 3; i++) cantor(n - 1, i, k + ((int) Math.pow(3, n - 1) * i));
	}
}