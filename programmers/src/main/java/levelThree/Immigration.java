package levelThree;

import java.util.Arrays;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * Category : 이분탐색
 * Describe : 전체 시간은 1 ~ 가장 오래 걸리는 입국심사 * 입국자
 */
public class Immigration {

	public long solution(long n, int[] times) {
		long answer = 0;
		int length = times.length;
		Arrays.sort(times);
		long maxTime = times[length - 1] * n;
		long start = 1L;
		long end = maxTime;

		if(start == end) return end;

		while (start < end) {
			long median = (start + end) / 2;
			long count = complete(median, times, length);
			if (count < n) {
				start = median + 1;
			} else {
				end = median;
			}
			answer = end;
		}
		return answer;
	}

	private long complete(long index, int[] times, int length) {
		long count = 0;
		for (int j = 0; j < length; j++) count += index / times[j];
		return count;
	}
}
