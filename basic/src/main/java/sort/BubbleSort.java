package sort;

import java.util.Arrays;

/**
 * Bubble Sort Algorithm
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 배열의 뒤에서부터 가장 처음 요소를 향해 스캔하다. 인접한 두 요소의 대소 관계가 반대라면 순서를 바꿔주는 것
 */
public class BubbleSort {

    public void sort(int[] arr) {
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}