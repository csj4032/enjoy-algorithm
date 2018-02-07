package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Equal {

	static int equal(int[] arr) {
		// Complete this function
		int m = arr.length;
		int c = 0;
		Arrays.sort(arr);
		for (int i = 1; i < m; i++) {
			if (arr[i] != arr[i - 1]) {
				while (arr[i] != arr[i - 1]) {
					int k = Math.abs(arr[i] - arr[i - 1]);
					int t = arr[i] > arr[i - 1] ? i : i - 1;
					//System.out.println(k);
					if (k == 1) {
						for (int l = 0; l < m; l++) {
							if (t != l) {
								arr[l] = arr[l] + 1;
							}
						}
					} else if (k < 5) {
						for (int l = 0; l < m; l++) {
							if (t != l) {
								arr[l] = arr[l] + 2;
							}
						}
					} else if (5 <= k) {
						for (int l = 0; l < m; l++) {
							if (t != l) {
								arr[l] = arr[l] + 5;
							}
						}
					}
					c++;
					//System.out.println(Arrays.toString(arr));
				}
			}

		}
		return c;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			int result = equal(arr);
			System.out.println(result);
		}
		in.close();
	}
}