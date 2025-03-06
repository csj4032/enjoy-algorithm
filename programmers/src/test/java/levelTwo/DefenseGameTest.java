package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefenseGameTest {

    @Test
    public void test() {
        DefenseGame defenseGame = new DefenseGame();
        Assertions.assertEquals(2, defenseGame.solution(1, 1, new int[]{1, 1}));
        Assertions.assertEquals(5, defenseGame.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        Assertions.assertEquals(11, defenseGame.solution(10000000, 4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10000000}));
        Assertions.assertEquals(4, defenseGame.solution(2, 4, new int[]{3, 3, 3, 3}));
        Assertions.assertEquals(7, defenseGame.solution(7, 1, new int[]{1, 1, 1, 1, 1, 1, 1}));
        Assertions.assertEquals(8, defenseGame.solution(7, 1, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }
}