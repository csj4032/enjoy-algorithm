package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BandageTest {

    @Test
    public void test() {
        Bandage bandage = new Bandage();
        //Assertions.assertEquals(5, bandage.solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        Assertions.assertEquals(-1, bandage.solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        //Assertions.assertEquals(-1, bandage.solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        //Assertions.assertEquals(3, bandage.solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
    }
}