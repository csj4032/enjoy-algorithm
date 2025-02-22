package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SchedulingTest {

    @Test
    void test() {
        Scheduling scheduling = new Scheduling();
        Assertions.assertEquals(2, scheduling.solution(6, new int[]{1, 2, 3}));
    }
}