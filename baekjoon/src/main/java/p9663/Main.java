package p9663;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n;
	static int[] m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n];
		recursive(0);
		System.out.println(Arrays.toString(m));
	}

	private static void recursive(int l) {

		if (l == n) {
			System.out.println(Arrays.toString(m));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (promise(l, i)) {
				m[l] = i;
				recursive(l + 1);
			}
		}
	}

	private static boolean promise(int l, int t) {
		for (int i = 0; i < l; i++) {
//			if (m[i] ==l || (Math.abs(m[i] - m[l]) == Math.abs(l - i))) {
//				return false;
//			}
			if (m[i] == l || (Math.abs(l - m[i]) == t - i))
			return false;

		}
		return true;
	}
}