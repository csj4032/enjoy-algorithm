package dbfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NetworkTest {

    @Test
    public void solutionTest() {
        Network network = new Network();
        Assertions.assertEquals(2, network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assertions.assertEquals(1, network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 1, 1}}));
    }
}