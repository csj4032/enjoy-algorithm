package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OilDrillingTest {

    @Test
    public void test() {
        OilDrilling oilDrilling = new OilDrilling();
        assertEquals(40, oilDrilling.solution(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}})
        );
        assertEquals(7, oilDrilling.solution(new int[][]{
                        {1, 1, 1, 1, 1, 1, 1}
                })
        );
    }
}