package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MazeEscapeTest {

    @Test
    public void test() {
        MazeEscape mazeEscape = new MazeEscape();
//        assertEquals(16, mazeEscape.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
//        assertEquals(-1, mazeEscape.solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
//        assertEquals(-1, mazeEscape.solution(new String[]{"SOOXL", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
        assertEquals(12, mazeEscape.solution(new String[]{"SOXLX", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
//        assertEquals(8, mazeEscape.solution(new String[]{"LOOOS", "OOOOO", "OOOOO", "OOOOO", "EOOOO"}));
//        assertEquals(8, mazeEscape.solution(new String[]{"OOOOS", "OOOOO", "OOOOO", "OOOOO", "EOOOL"}));
//        assertEquals(2, mazeEscape.solution(new String[]{"OOELS", "OOOOO", "OOOOO", "OOOOO", "OOOOO"}));
//        assertEquals(6, mazeEscape.solution(new String[]{"SOEOL", "OOOOO", "OOOOO", "OOOOO", "OOOOO"}));
//        assertEquals(16, mazeEscape.solution(new String[]{"SOEOOOOOOL", "OOOOOOOOOO", "OOOOOOOOOO", "OOOOOOOOOO", "OOOOOOOOOO"}));
//        assertEquals(2, mazeEscape.solution(new String[]{"SO0OOOOOO0", "LOOOOOOOOO", "EOOOOOOOOO", "OOOOOOOOOO", "OOOOOOOOOO"}));
//        assertEquals(3, mazeEscape.solution(new String[]{"SO0OOOOOO0", "EOOOOOOOOO", "LOOOOOOOOO", "OOOOOOOOOO", "OOOOOOOOOO"}));
    }
}