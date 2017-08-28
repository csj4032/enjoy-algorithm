package p9426;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 제목 : 골드바흐의 추측
 * 단계 : 소수 구하기
 * 힌트 : Fenwick Tree
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
		int m = ((k + 1) / 2);
		for (int i = 0; i < (n - k + 1); i++) {
			subArr = Arrays.copyOfRange(arr, i, i + k);
			sum += quickSelect(subArr, m-1);
		}
		System.out.println(sum);
	}

	private static Integer quickSelect(int[] array, int k) {
		int left = 0;
		int right = array.length - 1;
		Random rand = new Random();
		while (right >= left) {
			int pivotIndex = partition(array, left, right, rand.nextInt(right - left + 1) + left);
			if (pivotIndex == k) {
				return array[pivotIndex];
			} else if (pivotIndex < k) {
				left = pivotIndex + 1;
			} else {
				right = pivotIndex - 1;
			}
		}
		return null;
	}

	private static int partition(int[] array, int left, int right, int pivot) {
		int pivotVal = array[pivot];
		swap(array, pivot, right);
		int storeIndex = left;
		for (int i = left; i < right; i++) {
			if (array[i] < pivotVal) {
				swap(array, i, storeIndex);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex);
		return storeIndex;
	}

	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}