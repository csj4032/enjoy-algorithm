package p10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 제목 : 팰린드롬?
 * 링크 : https://www.acmicpc.net/problem/10942
 * 분류 : 다이나믹 프로그래밍
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		int[] m = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

		for (int i = 1; i <= n; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}

		int t = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bw.write(palindrome(s, e, m) + "\n");
		}
		bw.close();
	}

	private static int palindrome(int s, int e, int[] m) {
		while (s < e) {
			if (m[s++] != m[e--]) return 0;
		}
		return 1;
	}
}