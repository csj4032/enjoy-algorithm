package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

class VowelDictionaryTest {

	@Test
	public void test() throws ScriptException {
		VowelDictionary vowelDictionary = new VowelDictionary();
		Assertions.assertEquals(6, vowelDictionary.solution("AAAAE"));
	}
}