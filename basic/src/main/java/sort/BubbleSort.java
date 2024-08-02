package sort;

import java.util.Arrays;

public class BubbleSort {

    // 버블 정렬 메서드
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // 각 패스마다 마지막 i개의 요소는 이미 정렬된 상태입니다.
            for (int j = 0; j < n - 1 - i; j++) {
                // 인접한 두 요소를 비교하여 교환합니다.
                if (arr[j] > arr[j + 1]) {
                    // 요소를 교환합니다.
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("정렬 전 배열:");
        System.out.println(Arrays.toString(arr));
        // 버블 정렬 수행
        new BubbleSort().sort(arr);
        System.out.println("정렬 후 배열:");
        System.out.println(Arrays.toString(arr));
    }
}