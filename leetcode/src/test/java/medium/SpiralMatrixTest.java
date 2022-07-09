package medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrixTest {

	@Test
	void test() {
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(6);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(4);
		list.add(5);
		Assertions.assertEquals(list, spiralMatrix.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}
}