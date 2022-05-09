package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrinterTest {

	@Test
	public void test() {
		Printer printer = new Printer();
		Assertions.assertEquals(1, printer.solution(new int[]{2, 1, 3, 2}, 2));
		Assertions.assertEquals(5, printer.solution(new int[]{1, 1, 8, 1, 1, 1}, 0));
	}
}