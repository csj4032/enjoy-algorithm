package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WaterShortageTest {

    @Test
    public void test() {
        WaterShortage waterShortage = new WaterShortage();
        Assertions.assertEquals(1, waterShortage.solution(5141, 500, new int[]{10, -10, 10, -10, 10, -10, 10, -10, 10, -10}));
        Assertions.assertEquals(1, waterShortage.solution(1000, 2000, new int[]{-10, 25, -33}));
    }
}