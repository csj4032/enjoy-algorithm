package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlicingCakeTest {

    @Test
    public void test() {
        SlicingCake slicingCake = new SlicingCake();
        Assertions.assertEquals(2, slicingCake.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        Assertions.assertEquals(0, slicingCake.solution(new int[]{1, 2, 3, 1, 4}));
    }
}