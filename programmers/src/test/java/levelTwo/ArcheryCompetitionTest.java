package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArcheryCompetitionTest {

    @Test
    public void test() {
        ArcheryCompetition archeryCompetition = new ArcheryCompetition();
//        Assertions.assertArrayEquals(new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0}, archeryCompetition.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}));
//        Assertions.assertArrayEquals(new int[]{-1}, archeryCompetition.solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        Assertions.assertArrayEquals(new int[]{1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0}, archeryCompetition.solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}));
//        Assertions.assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2}, archeryCompetition.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}));
    }
}