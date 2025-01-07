package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TheMasterOfSoloFunTest {

    @Test
    public void test() {
        TheMasterOfSoloFun theMasterOfSoloFun = new TheMasterOfSoloFun();
        Assertions.assertEquals(12, theMasterOfSoloFun.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
        // Assertions.assertEquals(12, theMasterOfSoloFun.solution(new int[]{2, 1, 4, 5, 3, 7, 8, 9, 6}));
        Assertions.assertEquals(1, theMasterOfSoloFun.solution(new int[]{1, 2}));
        //Assertions.assertEquals(3, theMasterOfSoloFun.solution(new int[]{4, 3, 2, 1}));
    }
}