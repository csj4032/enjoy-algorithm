package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MagicElevatorTest {

    @Test
    public void test() {
        MagicElevator magicElevator = new MagicElevator();
        Assertions.assertEquals(1, magicElevator.solution(1));
//        Assertions.assertEquals(16, magicElevator.solution(2554));
//        Assertions.assertEquals(1, magicElevator.solution(1));
//        Assertions.assertEquals(1, magicElevator.solution(10));
        Assertions.assertEquals(6, magicElevator.solution(95));
//        Assertions.assertEquals(2, magicElevator.solution(999));
//        Assertions.assertEquals(1, magicElevator.solution(100000000));
    }
}