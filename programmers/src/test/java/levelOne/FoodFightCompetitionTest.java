package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FoodFightCompetitionTest {

    @Test
    public void test() {
        FoodFightCompetition foodFightCompetition = new FoodFightCompetition();
        Assertions.assertEquals("1223330333221", foodFightCompetition.solution(new int[]{1, 3, 4, 6}));
        Assertions.assertEquals("111303111", foodFightCompetition.solution(new int[]{1, 7, 1, 2}));
    }
}