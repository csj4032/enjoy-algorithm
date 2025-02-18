package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualizeQueuesTest {

    @Test
    public void test() {
        EqualizeQueues equalizeQueues = new EqualizeQueues();
//        Assertions.assertEquals(2, equalizeQueues.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
//        Assertions.assertEquals(7, equalizeQueues.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
//        Assertions.assertEquals(-1, equalizeQueues.solution(new int[]{1, 1}, new int[]{1, 5}));
//        Assertions.assertEquals(-1, equalizeQueues.solution(new int[]{2, 3}, new int[]{2, 1}));
//        Assertions.assertEquals(-1, equalizeQueues.solution(new int[]{1, 1, 1}, new int[]{2, 2, 2}));
//        Assertions.assertEquals(-1, equalizeQueues.solution(new int[]{1, 4, 4}, new int[]{2, 4, 4}));
//        Assertions.assertEquals(1, equalizeQueues.solution(new int[]{1, 3, 1, 3}, new int[]{1, 2, 1, 2}));
//        Assertions.assertEquals(-1, equalizeQueues.solution(new int[]{1}, new int[]{1000000000}));
       Assertions.assertEquals(-1, equalizeQueues.solution(new int[]{1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1}, new int[]{2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1}));
    }
}