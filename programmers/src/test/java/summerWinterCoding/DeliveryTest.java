package summerWinterCoding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeliveryTest {

	public int solution(int N, int[][] road, int K) {
		return new Delivery().likelihood(N, road, K);
	}

	@Test
	public void test() {
		Assertions.assertEquals(4, solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
		//Assertions.assertEquals(4, solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
	}
}