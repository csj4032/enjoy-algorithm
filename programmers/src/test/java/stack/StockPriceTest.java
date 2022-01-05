package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockPriceTest {

	private int[] solution(int[] prices) {
		StockPrice stockPrice = new StockPrice();
		return stockPrice.prices(prices);
	}

	@Test
	public void test() {
		Assertions.assertArrayEquals(new int[]{4, 3, 1, 1, 0}, solution(new int[]{1, 2, 3, 2, 3}));
	}
}