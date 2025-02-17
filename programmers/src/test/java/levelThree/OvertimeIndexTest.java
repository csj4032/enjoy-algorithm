package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OvertimeIndexTest {

    @Test
    public void test() {
        OvertimeIndex overtimeIndex = new OvertimeIndex();
        Assertions.assertEquals(12l, overtimeIndex.solution(4, new int[]{4, 3, 3}));
        //Assertions.assertEquals(6l, overtimeIndex.solution(1, new int[]{2, 1, 2}));
        // Assertions.assertEquals(0l, overtimeIndex.solution(3, new int[]{1, 1, 1}));
    }
}