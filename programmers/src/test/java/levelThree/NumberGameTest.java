package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberGameTest {

    @Test
    public void test() {
        NumberGame numberGame = new NumberGame();
        Assertions.assertEquals(3, numberGame.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
//        Assertions.assertEquals(0, numberGame.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
//        Assertions.assertEquals(0, numberGame.solution(new int[]{2, 2, 3, 3}, new int[]{2, 2, 2, 2}));
//        Assertions.assertEquals(1, numberGame.solution(new int[]{5, 5, 5, 9}, new int[]{4, 4, 9, 8}));
//        Assertions.assertEquals(3, numberGame.solution(new int[]{1, 1, 1, 1}, new int[]{1, 2, 2, 2}));
//        Assertions.assertEquals(3, numberGame.solution(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));
//        Assertions.assertEquals(1, numberGame.solution(new int[]{2, 2, 10, 10}, new int[]{2, 20, 2, 2}));
//        Assertions.assertEquals(2, numberGame.solution(new int[]{3, 3, 3, 4, 5}, new int[]{3, 3, 3, 4, 5}));
    }
}