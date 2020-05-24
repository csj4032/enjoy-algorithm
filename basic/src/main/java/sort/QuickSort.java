package sort;

public class QuickSort {

	public static void main(String[] args) {
		var arr = new int[]{5, 1, 3, 4, 2};
		quickSort(arr);
	}

	public static void quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int l, int r) {
		if (l >= r) return;
		int mid = partition(arr, l, r);
		sort(arr, l, mid - 1);
		sort(arr, mid, r);
	}

	private static int partition(int[] arr, int l, int r) {
		int pivot = arr[(l + r) / 2];
		while (l <= r) {
			while (arr[l] < pivot) l++;
			while (arr[r] > pivot) r--;
			if (l <= r) {
				swap(arr, l, r);
				l++;
				r--;
			}
		}
		return l;
	}

	private static void swap(int[] arr, int l, int r) {
		int tmp = arr[l];
		arr[l] = r;
		arr[r] = tmp;
	}
}