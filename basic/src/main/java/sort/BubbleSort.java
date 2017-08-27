package sort;

public class BubbleSort {

	public void sort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = length - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}
}