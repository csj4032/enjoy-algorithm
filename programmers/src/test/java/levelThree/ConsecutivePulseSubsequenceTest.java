package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsecutivePulseSubsequenceTest {

    @Test
    public void test(){
        ConsecutivePulseSubsequence consecutivePulseSubsequence = new ConsecutivePulseSubsequence();
        Assertions.assertEquals(10, consecutivePulseSubsequence.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
    }
}