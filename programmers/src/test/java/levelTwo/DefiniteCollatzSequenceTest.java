package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefiniteCollatzSequenceTest {

    @Test
    public void test() {
        DefiniteCollatzSequence definiteCollatzSequence = new DefiniteCollatzSequence();
        Assertions.assertArrayEquals(new double[]{33.0, 31.5, 0.0, -1}, definiteCollatzSequence.solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}}));
        Assertions.assertArrayEquals(new double[]{47.0, 36.0, 12.0}, definiteCollatzSequence.solution(3, new int[][]{{0, 0}, {1, -2}, {3, -3}}));
    }
}