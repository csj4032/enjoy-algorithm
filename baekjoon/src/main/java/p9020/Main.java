package p9020;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 제목 : 골드바흐의 추측
 * 단계 : 소수 구하기
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		String[] s = new String[n];

		for (int i = 0; i < n; i++) {
			List<Integer> l = new ArrayList();
			int m = Integer.parseInt(br.readLine().trim());
			for (int j = 2; j < m; j++) {
				if (prime(j)) {
					l.add(j);
				}
			}
			s[i] = partition(l, m);
		}

		for (int i = 0; i < s.length; i++) {
			bw.write(s[i] + "\n");
		}
		bw.close();
	}

	private static String partition(List<Integer> l, int m) {
		int min = Integer.MAX_VALUE;
		String partition = "";
		for (int i = 0; i < l.size(); i++) {
			int e = l.get(i);
			for (int j = i; j < l.size(); j++) {
				int k = l.get(j);
				if (e + k == m) {
					int gap = Math.abs(e - k);
					if (min > gap) {
						min = gap;
						partition = e + " " + k;
					}
					break;
				}
			}
		}
		return partition;
	}

	private static boolean prime(int n) {
		if (n < 2 || (n != 2 && n % 2 == 0)) return false;
		int s = (int) Math.sqrt(n);
		for (int i = 3; i <= s; i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
}