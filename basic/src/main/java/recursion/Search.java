package recursion;

public class Search {

	public int search(int[] data, int begin, int end, int target) {
		if (begin > end) {
			return -1;
		} else if (target == data[end]) {
			return end;
		} else {
			return search(data, begin, end - 1, target);
		}
	}

	public int search2(int[] data, int begin, int end, int target) {
		if (begin > end) {
			return -1;
		} else {
			int middle = (begin + end) / 2;
			if (data[middle] == target) {
				return middle;
			}
			int index = search2(data, begin, middle - 1, target);
			if (index != -1) {
				return index;
			} else {
				return search(data, middle + 1, end, target);
			}
		}
	}

	public int findMax(int[] data, int begin, int end) {
		if (begin == end) {
			return data[begin];
		} else {
			return Math.max(data[begin], findMax(data, begin + 1, end));
		}
	}

	public int findMax2(int[] data, int begin, int end) {
		if (begin == end) {
			return data[begin];
		} else {
			int middle = (begin + end) / 2;
			int max1 = findMax(data, begin, middle);
			int max2 = findMax(data, middle + 1, end);
			return Math.max(max1, max2);
		}
	}
}