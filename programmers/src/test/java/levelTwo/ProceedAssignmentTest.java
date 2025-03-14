package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProceedAssignmentTest {

    @Test
    public void test() {
        ProceedAssignment proceedAssignment = new ProceedAssignment();
        // Assertions.assertArrayEquals(new String[]{"korean", "english", "math"}, proceedAssignment.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}}));
        // Assertions.assertArrayEquals(new String[]{"science", "history", "computer", "music"}, proceedAssignment.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}}));
        // Assertions.assertArrayEquals(new String[]{"bbb", "ccc", "aaa"}, proceedAssignment.solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}}));
        Assertions.assertArrayEquals(new String[]{"ccc", "bbb", "aaa"}, proceedAssignment.solution(new String[][]{{"aaa", "12:00", "10"}, {"bbb", "12:00", "10"}, {"ccc", "12:00", "10"}}));
    }
}