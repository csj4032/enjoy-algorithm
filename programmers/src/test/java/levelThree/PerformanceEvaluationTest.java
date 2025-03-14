package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerformanceEvaluationTest {

    @Test
    public void test() {
        PerformanceEvaluation performanceEvaluation = new PerformanceEvaluation();
//        Assertions.assertEquals(1, performanceEvaluation.solution(new int[][]{{2, 2}}));
//        Assertions.assertEquals(3, performanceEvaluation.solution(new int[][]{{0, 0}, {1, 0}, {0, 1}}));
//        Assertions.assertEquals(1, performanceEvaluation.solution(new int[][]{{0, 0}, {0, 0}, {0, 0}}));
//        Assertions.assertEquals(-1, performanceEvaluation.solution(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
//        Assertions.assertEquals(1, performanceEvaluation.solution(new int[][]{{2, 0}, {1, 1}, {0, 0}}));
        Assertions.assertEquals(3, performanceEvaluation.solution(new int[][]{{3, 2}, {3, 4}, {3, 3}}));
//        Assertions.assertEquals(4, performanceEvaluation.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    }
}