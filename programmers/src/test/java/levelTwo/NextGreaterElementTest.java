package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NextGreaterElementTest {

    @Test
    public void test() {
        NextGreaterElement nextGreaterElement =new NextGreaterElement();
        // Assertions.assertArrayEquals(new int[]{3, 5, 5, -1}, nextGreaterElement.solution(new int[]{2, 3, 3, 5}));
        Assertions.assertArrayEquals(new int[]{-1, 5, 6, 6, -1, -1}, nextGreaterElement.solution(new int[]{9, 1, 5, 3, 6, 2}));
    }
}