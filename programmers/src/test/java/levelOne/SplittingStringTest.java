package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SplittingStringTest {

    @Test
    public void test() {
        SplittingString splittingString = new SplittingString();
        //Assertions.assertEquals(3, splittingString.solution("banana"));
        Assertions.assertEquals(6, splittingString.solution("abracadabra"));
        //Assertions.assertEquals(3, splittingString.solution("aaabbaccccabba"));
    }
}