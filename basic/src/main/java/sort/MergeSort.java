package sort;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] array) {
        int length = array.length;
        for (int size = 1; size < length; size *= 2) {
            for (int left = 0; left < length - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, length - 1);
                System.out.printf("size: %s, left : %s, mid : %s, right : %s\n", size, left, mid, right);
                merge(array, left, mid, right);
                System.out.println(Arrays.toString(array));
            }
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for (int i = 0; i < leftLength; i++) leftArray[i] = array[left + i];
        for (int i = 0; i < rightLength; i++) rightArray[i] = array[mid + i + 1];

        int i = 0, j = 0, k = left;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftLength) array[k++] = leftArray[i++];
        while (j < rightLength) array[k++] = rightArray[j++];
    }
}
