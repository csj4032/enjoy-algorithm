package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Friends4BlockTest {

	@Test
	public void test() {
		Friends4Block friends4Block = new Friends4Block();
		Assertions.assertEquals(14, friends4Block.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		Assertions.assertEquals(15, friends4Block.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
	}
}