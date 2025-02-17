package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordConversionTest {

    @Test
    public void test() {
        WordConversion wordConversion = new WordConversion();
        Assertions.assertEquals(4, wordConversion.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        Assertions.assertEquals(0, wordConversion.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));

        WordConversionBreadth wordConversionBreadth = new WordConversionBreadth();
        Assertions.assertEquals(4, wordConversionBreadth.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        Assertions.assertEquals(0, wordConversionBreadth.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}