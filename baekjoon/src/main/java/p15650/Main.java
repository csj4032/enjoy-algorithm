package p15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제목 : N과 M (2)
 * 링크 : https://www.acmicpc.net/problem/15650
 * 분류 : 조합, 순열, DFS
 */
public class Main {

	static int N;
	static int M;
	static int[] NUMBERS;
	static boolean[] VISITED;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		VISITED = new boolean[N];
		NUMBERS = new int[N];
		sb = new StringBuilder();
		permutation(0, 0);
		System.out.println(sb);
	}

	private static void permutation(int depth, int idx) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(NUMBERS[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			if (VISITED[i]) continue;
			VISITED[i] = true;
			NUMBERS[depth] = i + 1;
			permutation(depth + 1, i);
			VISITED[i] = false;
		}
		idx++;
	}
}
