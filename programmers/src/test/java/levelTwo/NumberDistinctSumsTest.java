package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberDistinctSumsTest {

    @Test
    public void test() {
        NumberDistinctSums numberDistinctSums = new NumberDistinctSums();
        Assertions.assertEquals(18, numberDistinctSums.solution(new int[]{7, 9, 1, 1, 4}));
    }
}