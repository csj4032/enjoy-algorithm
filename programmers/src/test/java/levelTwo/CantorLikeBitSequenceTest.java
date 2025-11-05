package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CantorLikeBitSequenceTest {

    @Test
    public void testSolution() {
        CantorLikeBitSequence cantorLikeBitSequence = new CantorLikeBitSequence();
        assertEquals(8, cantorLikeBitSequence.solution(2, 4, 17));
        assertEquals(4, cantorLikeBitSequence.solution(1, 1, 5));
        assertEquals(64, cantorLikeBitSequence.solution(3, 1, 125));
    }
}