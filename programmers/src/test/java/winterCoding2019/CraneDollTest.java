package winterCoding2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CraneDollTest {

	public int solution(int[][] board, int[] moves) {
		CraneDoll craneDoll = new CraneDoll(board);
		for (int i = 0; i < moves.length; i++) craneDoll.addBasket(moves[i]);
		return craneDoll.getBomb();
	}

	@Test
	public void test() {
		Assertions.assertEquals(4, solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
	}
}

/**
 * {0, 0, 0, 0, 0},
 * {0, 0, 1, 0, 3},
 * {0, 2, 5, 0, 1},
 * {4, 2, 4, 4, 2},
 * {3, 5, 1, 3, 1}
 */