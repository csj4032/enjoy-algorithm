package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NbaseGameTest {

    @Test
    public void test() {
        NbaseGame nbaseGame = new NbaseGame();
        Assertions.assertEquals("0111", nbaseGame.solution(2, 4, 2, 1));
        Assertions.assertEquals("02468ACE11111111", nbaseGame.solution(16, 16, 2, 1));
        Assertions.assertEquals("13579BDF01234567", nbaseGame.solution(16, 16, 2, 2));
    }
}