package basic;

import java.util.Arrays;

public class Solution2 {

	public static int[] solution(int N) {

		int length = (N * 2);
		int startIndex = N * -1;
		int[] number = new int[length];
		int[] result = new int[N];

		for (int i = 0; i < length; i++) {
			number[i] = startIndex + i;
		}

		for (int i = 0; i < length; i++) {
			int sum = 0;
			for (int j = i; j < length; j++) {
				sum += number[j];
				if (sum == 0) {
					int[] temp = Arrays.copyOfRange(number, i + 1, j);
					int n = 0, end = 0;
					if (temp.length > N) {
						for (int k = 0; k < temp.length; k++) {
							if (temp[k] < 0) n += temp[k];
							if (temp[k] == 0) end = k;
						}
						result[0] = n;
						temp = Arrays.copyOfRange(temp, end, temp.length);
						for (int k = 0; k < temp.length; k++) {
							result[k + 1] = temp[k];
						}
					} else {
						result = temp;
					}
					return result;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3)));
		System.out.println(Arrays.toString(solution(4)));
		System.out.println(Arrays.toString(solution(5)));
		System.out.println(Arrays.toString(solution(6)));
	}
}
