package sort;

import java.util.Arrays;

/**
 * Select Sort Algorithm
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 배열에서 가장 작은 요소를 찾아 맨 앞의 요소와 교환하는 것을 반복
 */
public class SelectSort {

    public void sort(int[] array) {
        int index, temp;
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            System.out.println(Arrays.toString(array));
        }
    }
}
