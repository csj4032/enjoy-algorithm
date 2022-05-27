package levelThree;

import java.util.Arrays;

public class Immigration {

	public long solution(int n, int[] times) {
		long answer = 0;
		int length = times.length;
		int[] imm = new int[length];
		Arrays.sort(times);
		System.out.println(lowerBound(times, 0, length));
		System.out.println(upperBound(times, 0, length));
		return answer;
	}

	private int lowerBound(int[] array, int target, int size) {
		int mid;
		int start = 0;
		int end = size - 1;
		while (end > start) {
			mid = (end + start) / 2;
			if (array[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

	private int upperBound(int[] array, int target, int size) {
		int mid;
		int start = 0;
		int end = size - 1;
		while (end > start) {
			mid = (start + end) / 2;
			if (array[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}
