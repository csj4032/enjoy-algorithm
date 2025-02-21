package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BetweenTwoCirclesTest {

    @Test
    public void test() {
        BetweenTwoCircles betweenTwoCircles = new BetweenTwoCircles();
        Assertions.assertEquals(12, betweenTwoCircles.solution(1, 2));
        Assertions.assertEquals(28, betweenTwoCircles.solution(1, 3));
        Assertions.assertEquals(20, betweenTwoCircles.solution(2, 3));
    }
}