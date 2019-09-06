package p11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제목 : 구간 합 구하기 4
 * 링크 : https://www.acmicpc.net/problem/11659
 */
public class Main {

	private static int[] m;
	private static int[] l;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		m = new int[n];
		l = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			m[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				l[i] = m[i];
			} else {
				l[i] = l[i - 1] + m[i];
			}
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(sectionSum(s - 1, e - 1));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int sectionSum(int s, int e) {
		return l[e] - (l[s] - m[s]);
	}
}
