package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BetweenTwoCirclesTest {

    @Test
    public void test() {
        BetweenTwoCircles betweenTwoCircles = new BetweenTwoCircles();
        Assertions.assertEquals(20l, betweenTwoCircles.solution(2, 3));
    }
}