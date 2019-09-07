package p11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] p = new int[n];
		int[] q = new int[m];

		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < n; i++) p[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 0; i < m; i++) q[i] = Integer.parseInt(st.nextToken());

		int i = 0;
		int j = 0;
		while (true) {
			int a = p[i];
			int b = q[j];
			if (a > b) {
				sb.append(b + " ");
				j++;
			} else {
				sb.append(a + " ");
				i++;
			}
			if (i == n) break;
			if (j == m) break;
		}
		for (; i < n; i++) sb.append(p[i] + " ");
		for (; j < m; j++) sb.append(q[j] + " ");
		System.out.println(sb.toString());
	}
}