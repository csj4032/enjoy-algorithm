package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HallOfFameTest {

    @Test
    public void test() {
        HallOfFame hallOfFame = new HallOfFame();
        Assertions.assertArrayEquals(new int[]{10, 10, 10, 20, 20, 100, 100}, hallOfFame.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300}, hallOfFame.solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}));
    }
}