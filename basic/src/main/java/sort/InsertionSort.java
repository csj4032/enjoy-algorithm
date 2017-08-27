package sort;

public class InsertionSort {

	public void sort(int[] array) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			int j = i;
			while (j >= 1 && array[j - 1] > array[j]) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j--;
			}
		}
	}
}