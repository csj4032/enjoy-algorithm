package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EditTableTest {

	@Test
	public void test() {
		EditTable editTable = new EditTable();
		//Assertions.assertEquals("OOOOXOOO", editTable.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
		Assertions.assertEquals("OOXOXOOO", editTable.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
	}
}