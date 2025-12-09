package search;

public class BinarySearch {

    public int binarySearch(int[] sortedArray, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] == key) {
                return mid;
            } else if (sortedArray[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}