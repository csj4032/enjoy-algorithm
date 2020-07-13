package p9081;

import java.util.*;

/**
 * 제목 : 단어 맞추기
 * 링크 : https://www.acmicpc.net/problem/9081
 * 분류 : Next Permutation
 * 참고 : https://tttuer.tistory.com/212?category=776472
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();
		var set = new HashSet<String>();
		for (int i = 0; i < t; i++) {
			var s1 = sc.next();
			set.clear();
			dfs(s1.length(), s1.length(), 0, s1.split(""), set);
			List<String> ll = new ArrayList<>(set);
			Collections.sort(ll);
			var idx = ll.indexOf(s1);
			if (ll.size() == idx + 1) {
				sb.append(ll.get(ll.size() - 1));
			} else {
				sb.append(ll.get(idx + 1));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int n, int m, int d, String[] str, HashSet<String> set) {
		if (d == m) {
			var ss = "";
			for (int i = 0; i < str.length; i++) ss += str[i];
			set.add(ss);
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(i, d, str);
			dfs(n, m, d + 1, str, set);
			swap(i, d, str);
		}
	}

	private static void swap(int i, int m, String[] str) {
		var temp = str[i];
		str[i] = str[m];
		str[m] = temp;
	}
}
