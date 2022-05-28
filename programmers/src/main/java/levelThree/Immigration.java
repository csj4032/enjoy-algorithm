package levelThree;

import java.util.Arrays;

/**
 * 입국심사를 기다리는 사람 수를 적당히 나워서 심사를 처리
 * 심사원은 최대한 동일한 입국자를 할당
 * 심사를 받는데 걸리는 최대 시간에서 최소 시간으로 입국자를 넘김
 * 최소 시간이 다시 늘어나는 시점에 종료
 */
public class Immigration {

	public long solution(int n, int[] times) {
		long answer = 0;
		long temp = Long.MAX_VALUE;
		int length = times.length;
		int portion = n / length;
		int remainder = n % length;
		long[] imm = new long[length];
		Arrays.sort(times);
		Arrays.fill(imm, portion);
		for (int i = 0; i < remainder; i++) {
			imm[i] = imm[i] + 1;
		}
		//System.out.println(Arrays.toString(imm));
		while (true) {
			long max = Long.MIN_VALUE;
			int iMax = 0;
			long min = Long.MAX_VALUE;
			int iMin = 0;
			for (int i = 0; i < length; i++) {
				long time = imm[i] * times[i];
				if (time == 0) continue;
				if (max <= time) {
					max = time;
					iMax = i;
				}
				if (min >= time) {
					min = time;
					iMin = i;
				}
			}
			imm[iMax] = imm[iMax] - 1;
			imm[iMin] = imm[iMin] + 1;
			answer = max;
			//System.out.println(answer + " " + max + " " + temp);
			if (answer >= temp) {
				answer = temp;
				break;
			}
			temp = answer;
		}
		return answer;
	}
}
