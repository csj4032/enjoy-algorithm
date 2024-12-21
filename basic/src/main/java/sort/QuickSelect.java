package sort;

import java.util.Arrays;

public class QuickSelect {

	public int quickSelect(int[] array, int k) {
		int len = array.length;
		if (array == null || len <= k) {
			return -1;
		}

		int start = 0;
		int end = len - 1;

		while (start < end) {

			int i = start;
			int j = end;
			int mid = array[(i + j) / 2];

			while (i < j) {
				if (array[i] >= mid) {
					int tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
					j--;
				} else {
					i++;
				}
			}

			if(array[i] > mid) {
				i--;
			}

			if (k <= i) {
				end = i;
			} else {
				start = i + 1;
			}
		}
		System.out.println(Arrays.toString(array));
		return array[k];
	}
}