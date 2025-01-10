package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateRectangleTest {

    @Test
    public void test() {
        CalculateRectangle calculateRectangle = new CalculateRectangle();
        //Assertions.assertEquals(1, calculateRectangle.solution(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
        Assertions.assertEquals(4, calculateRectangle.solution(new int[][]{{-1, -1}, {1, 1}, {1, -1}, {-1, 1}}));
    }
}