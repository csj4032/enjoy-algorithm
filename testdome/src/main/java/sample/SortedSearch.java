package dbfs;

public class SortedSearch {

	public static int countNumbers(int[] sortedArray, int lessThan) {
		int start = 0;
		int end = sortedArray.length;
		int mid = 0;
		while (end - start > 0) {
			mid = (start + end) / 2;
			if (sortedArray[mid] < lessThan) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}

	public static void main(String[] args) {
		System.out.println(SortedSearch.countNumbers(new int[]{1,4}, 4));
	}
}
