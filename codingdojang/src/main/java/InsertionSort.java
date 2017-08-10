import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] i = new int[]{5, 2, 4, 6, 1};
		insertionSort(i);
	}

	private static void insertionSort(int[] i) {
		int l = i.length;
		for (int j = 1; j < l; j++) {
			int a = i[j];
			for (int k = 0; k < j; k++) {
				if (a < i[k]) {
					int t = a;
					int n = k;
					while (n < j) {
						i[j] = i[j - 1];
						j--;
					}
					i[k] = t;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(i));
	}
}
