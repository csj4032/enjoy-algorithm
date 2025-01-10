package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmallSubstringTest {

    @Test
    public void test() {
        SmallSubstring smallSubstring = new SmallSubstring();
        Assertions.assertEquals(2, smallSubstring.solution("3141592", "271"));
        Assertions.assertEquals(8, smallSubstring.solution("500220839878", "7"));
        Assertions.assertEquals(3, smallSubstring.solution("10203", "15"));
    }
}