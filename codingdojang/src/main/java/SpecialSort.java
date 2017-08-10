import java.util.Arrays;

public class SpecialSort {

	public static void main(String[] args) {
		int n = 5;
		int[] a = new int[]{-1, 1, 3, -2, 2};

		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (a[j - 1] * a[j] < 0 && a[j - 1] > a[j]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(a));
	}
}