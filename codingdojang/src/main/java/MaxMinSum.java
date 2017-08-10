import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxMinSum {

	static BigDecimal max = BigDecimal.ZERO;
	static BigDecimal min = BigDecimal.ZERO;

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		permutation(arr, 0, arr.length, arr.length);
		System.out.println(max.add(min));
	}

	private static void permutation(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			BigDecimal bd = new BigDecimal(Arrays.stream(arr).boxed().map(i -> String.valueOf(i)).collect(Collectors.joining()));
			if (bd.compareTo(max) > 0) max = bd;
			if (bd.compareTo(min) < 0 || min == BigDecimal.ZERO) min = bd;
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
	}
}
