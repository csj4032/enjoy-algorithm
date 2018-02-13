package p3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제목 : 나머지
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[] m = new boolean[42];
		int r = 0;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			m[n % 42] = true;
		}

		for (int i = 0; i < 42; i++) if (m[i]) r++;

		System.out.println(r);
	}
}