package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThrowingBallTest {

    @Test
    public void test(){
        ThrowingBall throwingBall = new ThrowingBall();
        Assertions.assertEquals(1, throwingBall.solution(new int[]{1, 2, 3, 4}, 2));
    }
}