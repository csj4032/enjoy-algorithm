package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectingIslandsTest {

    @Test
    public void test() {
        ConnectingIslands connectingIslands = new ConnectingIslands();
        Assertions.assertEquals(0, connectingIslands.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}