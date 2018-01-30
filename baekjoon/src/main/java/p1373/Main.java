package p1373;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map m = new HashMap();

	static {
		m.put("0", "0");
		m.put("000", "0");
		m.put("001", "1");
		m.put("1", "1");
		m.put("010", "2");
		m.put("10", "2");
		m.put("011", "3");
		m.put("11", "3");
		m.put("100", "4");
		m.put("101", "5");
		m.put("110", "6");
		m.put("111", "7");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.next();
		int l = s.length();
		int n = (int) Math.ceil((double) l / 3);
		int t;
		int k;
		for (int i = 0; i < n; i++) {
			k = l - (3 * i) - 3;
			t = l - (3 * i);
			if (k < 0) k = 0;
			sb.append(m.get(s.substring(k, t)));
		}

		System.out.println(sb.reverse().toString());
	}
}