package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkWalkTest {

    @Test
    public void test() {
        ParkWalk parkWalk = new ParkWalk();
        Assertions.assertArrayEquals(new int[]{2, 1}, parkWalk.solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"}));
        Assertions.assertArrayEquals(new int[]{0, 1}, parkWalk.solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"}));
        Assertions.assertArrayEquals(new int[]{0, 0}, parkWalk.solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"}));
    }
}