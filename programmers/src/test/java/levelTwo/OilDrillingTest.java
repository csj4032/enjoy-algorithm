package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OilDrillingTest {

    @Test
    public void test() {
        OilDrilling oilDrilling = new OilDrilling();
        assertEquals(9, oilDrilling.solution(new int[][]{
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}})
        );
//        assertEquals(16, oilDrilling.solution(new int[][]{
//                {1, 0, 1, 0, 1, 1},
//                {1, 0, 1, 0, 0, 0},
//                {1, 0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 0, 0},
//                {1, 0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1}})
//        );
    }
}