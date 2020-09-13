package p7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제목 : 먹을 것인가 먹힐 것인가
 * 링크 : https://www.acmicpc.net/problem/7795
 * 분류 :이분 탐색 (Lower Bound), 정렬, 두 포인터
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var t = Integer.parseInt(br.readLine());
		var sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			var a = Integer.parseInt(st.nextToken());
			var b = Integer.parseInt(st.nextToken());
			var aa = new int[a];
			var bb = new Integer[b];

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < a; j++) aa[j] = Integer.parseInt(st2.nextToken());
			for (int j = 0; j < b; j++) bb[j] = Integer.parseInt(st3.nextToken());

			Arrays.sort(bb);

			var k = 0;
			for (int j = 0; j < a; j++) {
				var m = lowerBound(bb, b, aa[j]);
				if (bb[m] < aa[j]) {
					k += (m + 1);
				} else {
					k += m;
				}
			}
			sb.append(k + " \n");
		}
		System.out.println(sb.toString());
	}

	private static int lowerBound(Integer[] arr, int size, int target) {
		int mid;
		int start = 0;
		int end = size - 1;
		while (end > start) {
			mid = (start + end) / 2;
			if (arr[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}