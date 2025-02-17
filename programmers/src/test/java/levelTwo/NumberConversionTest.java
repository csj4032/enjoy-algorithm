package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberConversionTest {

    @Test
    public void test() {
        NumberConversion numberConversion = new NumberConversion();
        Assertions.assertEquals(2, numberConversion.solution(10, 40,5));
        Assertions.assertEquals(1, numberConversion.solution(10, 40,30));
        Assertions.assertEquals(-1, numberConversion.solution(2, 5,4));
    }
}