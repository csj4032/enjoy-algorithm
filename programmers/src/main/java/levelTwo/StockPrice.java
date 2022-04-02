package levelTwo;

import java.util.Arrays;

public class StockPrice {

	public int[] prices(int[] prices) {
		int[] result = new int[prices.length];
		Arrays.fill(result, -1);
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				result[i]++;
				if (prices[i] > prices[j]) break;
			}
		}
		return result;
	}
}
