package levelTwo;

import java.util.Arrays;

public class HIndex {

	public int index(int[] citations) {
		int index = 0;
		int length = citations.length;
		int max = Arrays.stream(citations).max().getAsInt();
		int values[] = new int[max + 1];
		for (int i = 0; i < length; i++) values[citations[i]]++;
		int sum = 0;
		for (int i = max; i >= 0; i--) {
			sum += values[i];
			if (sum >= i) {
				for (int j = i - 1; j > -1; j--) {
					if (i < values[j]) {
						break;
					}
					index = Math.max(i, index);
				}
			}
		}
		return index;
	}
}
