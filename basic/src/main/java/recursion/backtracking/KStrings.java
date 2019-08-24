package recursion.backtracking;

import java.util.Arrays;

public class KStrings {

	public void KString(int n, int k, int[] a) {
		if (n < 1) {
			System.out.println(Arrays.toString(a));
		} else {
			for (int i = 0; i < k; i++) {
				a[n-1] = i;
				KString(n-1, k, a);
			}
		}
	}
}
