package sort;

import java.util.Arrays;

public class QuickSort {

    // 배열을 퀵 정렬하는 메서드
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            // 분할 인덱스를 받습니다.
            int pi = partition(arr, low, high);
            // 분할 인덱스를 기준으로 배열을 두 부분으로 나누어 정렬합니다.
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // 배열을 분할하고 분할 인덱스를 반환하는 메서드
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 기준점을 배열의 마지막 원소로 선택합니다.
        int i = (low - 1); // 작은 원소의 인덱스를 나타냅니다.
        for (int j = low; j < high; j++) {
            // 현재 원소가 기준점보다 작은 경우
            if (arr[j] < pivot) {
                i++;
                // arr[i]와 arr[j]를 교환합니다.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // arr[i+1]과 기준점(arr[high])을 교환합니다.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // 메인 메서드
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("정렬 전 배열:");
        System.out.println(Arrays.toString(arr));
        // 퀵 정렬 수행
        new QuickSort().sort(arr, 0, arr.length - 1);
        System.out.println("정렬 후 배열:");
        System.out.println(Arrays.toString(arr));
    }
}
