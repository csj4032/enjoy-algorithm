package p9426;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 골드바흐의 추측
 * 단계 : 소수 구하기
 * 힌트 : Quick Select
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int[] subArr;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		long sum = 0;
		int m = k % 2 != 0 ? k / 2 : k / 2 - 1;
		for (int i = 0; i < (n - k + 1); i++) {
			subArr = Arrays.copyOfRange(arr, i, i + k);
			sum += quickSelect(subArr, m);
		}
		System.out.println(sum);
	}

	public static int quickSelect(int[] nums, int k) {
		int start = 0;
		int end = nums.length;
		int index = nums.length - k;
		return 0;
	}
}