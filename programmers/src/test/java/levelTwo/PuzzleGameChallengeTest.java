package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PuzzleGameChallengeTest {

    @Test
    public void test() {
        PuzzleGameChallenge puzzleGameChallenge = new PuzzleGameChallenge();
        Assertions.assertEquals(3, puzzleGameChallenge.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30));
        Assertions.assertEquals(2, puzzleGameChallenge.solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59));
        Assertions.assertEquals(294, puzzleGameChallenge.solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723));
        Assertions.assertEquals(39354, puzzleGameChallenge.solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L));
    }
}