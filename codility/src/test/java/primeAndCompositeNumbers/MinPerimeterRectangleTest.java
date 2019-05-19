package primeAndCompositeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPerimeterRectangleTest {

	@Test
	void solution() {
		MinPerimeterRectangle minPerimeterRectangle = new MinPerimeterRectangle();
		Assertions.assertEquals(22, minPerimeterRectangle.solution(30));
		Assertions.assertEquals(24, minPerimeterRectangle.solution(36));
		Assertions.assertEquals(30972904, minPerimeterRectangle.solution(15486451));
		Assertions.assertEquals(40000, minPerimeterRectangle.solution(100000000));
		Assertions.assertEquals(126500, minPerimeterRectangle.solution(1000000000));
		//Assertions.assertEquals(28, minPerimeterRectangle.solution(1000000000));
	}
}