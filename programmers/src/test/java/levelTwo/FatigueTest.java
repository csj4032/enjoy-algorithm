package levelTwo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FatigueTest {

    @Test
    public void test() {
        Fatigue fatigue = new Fatigue();
        Assertions.assertEquals(3, fatigue.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}