package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepaintingTest {

    @Test
    public void test() {
        Repainting repainting = new Repainting();
        Assertions.assertEquals(2, repainting.solution(8, 4, new int[]{2, 3, 6}));
        Assertions.assertEquals(1, repainting.solution(5, 4, new int[]{1, 3}));
        Assertions.assertEquals(4, repainting.solution(4, 1, new int[]{1, 2, 3, 4}));
    }
}