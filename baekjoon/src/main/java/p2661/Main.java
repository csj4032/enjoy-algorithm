package p2661;

import java.util.Scanner;

public class Main {

	private static int k;
	private static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		good(0, "");
	}

	private static void good(int n, String m) {
		if (n == k) {
			System.out.println(m);
			flag = true;
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (promise(m + i) && !flag) good(n + 1, m + i);
		}
	}

	private static boolean promise(String m) {
		int l = m.length();
		for (int i = 0; i < l / 2; i++) {
			String a = m.substring(l - ((i + 1) * 2), l - (i + 1));
			String b = m.substring(l - (i + 1), l);
			if (a.equals(b)) return false;
		}
		return true;
	}
}
