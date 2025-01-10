package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThrowingBallTest {

    @Test
    public void test() {
        ThrowingBall throwingBall = new ThrowingBall();
        Assertions.assertEquals(3, throwingBall.solution(new int[]{1, 2, 3, 4}, 2));
        Assertions.assertEquals(3, throwingBall.solution(new int[]{1, 2, 3, 4, 5, 6}, 5));
        Assertions.assertEquals(3, throwingBall.solution(new int[]{1, 2, 3}, 2));
    }
}