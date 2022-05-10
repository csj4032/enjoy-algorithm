package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

class TupleTest {

	@Test
	public void test() throws ScriptException {
		Tuple tuple = new Tuple();
		Assertions.assertArrayEquals(new int[]{2, 1, 3, 4}, tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
	}
}