package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeesawBuddyTest {

    @Test
    public void test() {
        SeesawBuddy seesawBuddy = new SeesawBuddy();
        Assertions.assertEquals(1l, seesawBuddy.solution(new int[]{100, 100}));
        Assertions.assertEquals(1l, seesawBuddy.solution2(new int[]{100, 100}));
        Assertions.assertEquals(4l, seesawBuddy.solution(new int[]{100, 180, 360, 100, 270}));
        Assertions.assertEquals(4l, seesawBuddy.solution2(new int[]{100, 180, 360, 100, 270}));
        Assertions.assertEquals(8l, seesawBuddy.solution(new int[]{1, 2, 2, 1, 3}));
        Assertions.assertEquals(8l, seesawBuddy.solution2(new int[]{1, 2, 2, 1, 3}));
        Assertions.assertEquals(9l, seesawBuddy.solution(new int[]{100, 200, 200, 180, 360, 100, 270}));
        Assertions.assertEquals(9l, seesawBuddy.solution2(new int[]{100, 200, 200, 180, 360, 100, 270}));
        Assertions.assertEquals(6, seesawBuddy.solution(new int[]{100, 100, 200, 200}));
        Assertions.assertEquals(6, seesawBuddy.solution2(new int[]{100, 100, 200, 200}));
        Assertions.assertEquals(3, seesawBuddy.solution(new int[]{100, 100, 100}));
        Assertions.assertEquals(3, seesawBuddy.solution2(new int[]{100, 100, 100}));
        Assertions.assertEquals(0, seesawBuddy.solution(new int[]{1000, 100, 101, 102}));
        Assertions.assertEquals(0, seesawBuddy.solution2(new int[]{1000, 100, 101, 102}));
        Assertions.assertEquals(4, seesawBuddy.solution(new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(4, seesawBuddy.solution2(new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(1, seesawBuddy.solution(new int[]{1, 2}));
    }
}