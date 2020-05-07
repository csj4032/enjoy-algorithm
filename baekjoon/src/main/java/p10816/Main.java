package p10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] m = new int[n];
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			m[i] = k;
			if (map.get(k) == null) {
				map.put(k, 1);
			} else {
				int v = map.get(k);
				map.put(k, v + 1);
			}
		}

		var l = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		var sb = new StringBuffer();
		for (int i = 0; i < l; i++) {
			int k = Integer.parseInt(st2.nextToken());
			if (map.get(k) == null) {
				sb.append(0);
			} else {
				sb.append(map.get(k));
			}
			sb.append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}
