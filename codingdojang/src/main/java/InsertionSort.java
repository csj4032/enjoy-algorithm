public class InsertionSort {

    // 삽입 정렬 메서드
    public static void insertionSort(int[] arr) {
        // 배열의 두 번째 원소부터 마지막 원소까지 반복
        for (int i = 1; i < arr.length; i++) {
            // 현재 원소를 key로 설정
            int key = arr[i];
            // 정렬된 부분의 마지막 인덱스
            int j = i - 1;
            // key보다 큰 원소를 오른쪽으로 한 칸씩 이동
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // key를 정렬된 부분의 적절한 위치에 삽입
            arr[j + 1] = key;
        }
    }

    // 배열 출력 메서드
    public static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    // 메인 메서드
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("정렬 전 배열:");
        printArray(arr);
        // 삽입 정렬 수행
        insertionSort(arr);
        System.out.println("정렬 후 배열:");
        printArray(arr);
    }
}
