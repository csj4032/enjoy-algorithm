package levelThree;

import java.util.Arrays;

public class Immigration {

	public long solution(int n, int[] times) {
		long answer = 0;
		int idx = 0;
		int length = times.length;
		Arrays.sort(times);
		int[] imm = new int[length];
		//int[] imm = Arrays.copyOf(times, length);
		while (true) {
			answer++;
			Arrays.sort(imm);
			int lower = lowerBound(imm, 0, length);
			int upper = upperBound(imm, 0, length);
			System.out.println(lower + " " + upper + " " + Arrays.toString(imm) + " " + answer + " " + n);
			if (lower != upper) {
				for (int i = lower; i <= upper; i++) {
					if (imm[i] > 0) continue;
					n--;
					imm[i] = times[idx];
					idx++;
					idx = idx % length;
				}
			} else {
				for (int i = 0; i < length; i++) {
					imm[i] = imm[i] - 1;
				}
			}
			if (n < 0 && (lower < upper)) break;
		}
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
