package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefenseGameTest {

    @Test
    public void test() {
        DefenseGame defenseGame = new DefenseGame();
        Assertions.assertEquals(2, defenseGame.solution(1, 1, new int[]{2, 1}));
        Assertions.assertEquals(2, defenseGame.solution(1, 1, new int[]{1, 1}));
        Assertions.assertEquals(1, defenseGame.solution(1, 1, new int[]{2, 2}));
        Assertions.assertEquals(5, defenseGame.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        Assertions.assertEquals(11, defenseGame.solution(10000000, 4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10000000}));
        Assertions.assertEquals(4, defenseGame.solution(2, 4, new int[]{3, 3, 3, 3}));
        Assertions.assertEquals(7, defenseGame.solution(7, 1, new int[]{1, 1, 1, 1, 1, 1, 1}));
        Assertions.assertEquals(2, defenseGame.solution(1, 1, new int[]{1, 1, 1, 1, 1, 1, 1}));
        Assertions.assertEquals(5, defenseGame.solution(10, 2, new int[]{3, 2, 4, 1, 5}));
        Assertions.assertEquals(4, defenseGame.solution(3, 3, new int[]{5, 7, 2, 6}));
        Assertions.assertEquals(3, defenseGame.solution(5, 2, new int[]{5, 8, 2, 10, 12}));
        Assertions.assertEquals(6, defenseGame.solution(50, 3, new int[]{10, 5, 15, 8, 7, 6}));

        //Assertions.assertEquals(4, defenseGame.solution(1_000_000_000, 500_000, new int[1_000_000]));
    }
}