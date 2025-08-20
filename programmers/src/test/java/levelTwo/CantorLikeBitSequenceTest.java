package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CantorLikeBitSequenceTest {

    @Test
    public void testSolution() {
        CantorLikeBitSequence cantorLikeBitSequence = new CantorLikeBitSequence();
        assertEquals(3, cantorLikeBitSequence.solution(2, 1, 5));
        assertEquals(0, cantorLikeBitSequence.solution(1, 1, 1));
        assertEquals(7, cantorLikeBitSequence.solution(3, 1, 8));
        assertEquals(15, cantorLikeBitSequence.solution(4, 1, 16));
    }
}