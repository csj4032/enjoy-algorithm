package kakaoBlindRecuitment2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringZipTest {

	public int solution(String s) {
		StringZip stringZip = new StringZip();
		return stringZip.zip(s);
	}


	@Test
	public void test() {
		Assertions.assertEquals(7, solution("aabbaccc"));
		Assertions.assertEquals(9, solution("ababcdcdababcdcd"));
		Assertions.assertEquals(8, solution("abcabcdede"));
		Assertions.assertEquals(14, solution("abcabcabcabcdededededede"));
		Assertions.assertEquals(17, solution("xababcdcdababcdcd"));
	}
}