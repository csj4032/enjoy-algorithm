package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataAnalysisTest {

    @Test
    public void test() {
        DataAnalysis dataAnalysis = new DataAnalysis();
        Assertions.assertArrayEquals(new int[][]{{3, 20300401, 10, 8}, {1, 20300104, 100, 80}},
                dataAnalysis.solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, "remain"));
    }
}