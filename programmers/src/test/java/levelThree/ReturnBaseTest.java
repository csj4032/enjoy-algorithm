package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReturnBaseTest {

    @Test
    public void test() {
        ReturnBase returnBase = new ReturnBase();
        Assertions.assertArrayEquals(new int[]{1, 2}, returnBase.solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1));
        Assertions.assertArrayEquals(new int[]{2, -1, 0}, returnBase.solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5));
    }
}
