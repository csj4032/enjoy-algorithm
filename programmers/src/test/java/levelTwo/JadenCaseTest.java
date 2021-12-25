package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JadenCaseTest {

	public String solution(String s) {
		JadenCase jadenCase = new JadenCase();
		return jadenCase.convert(s);
	}

	@Test
	public void test() {
		Assertions.assertEquals("3people Unfollowed Me", solution("3people unFollowed me"));
		Assertions.assertEquals("For The Last Week", solution("for the last week"));
		Assertions.assertEquals("Aa A", solution("aa a"));
		Assertions.assertEquals("   A", solution("   a"));
		Assertions.assertEquals("A   ", solution("a   "));
		Assertions.assertEquals("A   A ", solution("a   a "));
		Assertions.assertEquals("!@#", solution("!@#"));
	}
}