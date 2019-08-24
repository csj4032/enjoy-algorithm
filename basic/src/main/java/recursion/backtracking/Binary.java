package recursion.backtracking;

import java.util.Arrays;

public class Binary {

	public void binary(int n, int [] a) {
		if (n < 1) {
			System.out.println(Arrays.toString(a));
		} else {
			a[n - 1] = 0;
			binary(n - 1, a);
			a[n - 1] = 1;
			binary(n - 1, a);
		}
	}
}
