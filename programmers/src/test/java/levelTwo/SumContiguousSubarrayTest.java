package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumContiguousSubarrayTest {

    @Test
    public void test() {
        SumContiguousSubarray sumContiguousSubarray = new SumContiguousSubarray();
        Assertions.assertArrayEquals(new int[]{2, 3}, sumContiguousSubarray.solution(new int[]{1, 2, 3, 4, 5}, 7));
        Assertions.assertArrayEquals(new int[]{6, 6}, sumContiguousSubarray.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5));
        Assertions.assertArrayEquals(new int[]{0, 2}, sumContiguousSubarray.solution(new int[]{2, 2, 2, 2, 2}, 6));
    }
}