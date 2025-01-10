package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumOfConsecutiveNumbersTest {

    @Test
    public void test() {
        SumOfConsecutiveNumbers sumOfConsecutiveNumbers = new SumOfConsecutiveNumbers();
        Assertions.assertArrayEquals(new int[]{1}, sumOfConsecutiveNumbers.solution(1, 1));
        Assertions.assertArrayEquals(new int[]{3, 4, 5}, sumOfConsecutiveNumbers.solution(3, 12));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sumOfConsecutiveNumbers.solution(5, 15));
        Assertions.assertArrayEquals(new int[]{2, 3, 4, 5}, sumOfConsecutiveNumbers.solution(4, 14));
        Assertions.assertArrayEquals(new int[]{-1, 0, 1, 2, 3}, sumOfConsecutiveNumbers.solution(5, 5));
    }
}