package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClosestMatchingWordTest {

    @Test
    public void test() {
        ClosestMatchingWord closestMatchingWord = new ClosestMatchingWord();
        Assertions.assertArrayEquals(new int[]{-1, -1, -1, 2, 2, 2}, closestMatchingWord.solution("banana"));
        Assertions.assertArrayEquals(new int[]{-1, -1, 1, -1, -1, -1}, closestMatchingWord.solution("foobar"));
    }
}