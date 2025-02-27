package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MazeEscapeTest {

    @Test
    public void test() {
        MazeEscape mazeEscape = new MazeEscape();
//        assertEquals(16, mazeEscape.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
//        assertEquals(-1, mazeEscape.solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
//        assertEquals(8, mazeEscape.solution(new String[]{"LOOOS","OOOOO","OOOOO","OOOOO","EOOOO"}));
        assertEquals(8, mazeEscape.solution(new String[]{"OOOOS","OOOOO","OOOOO","OOOOO","EOOOL"}));
//      assertEquals(2, mazeEscape.solution(new String[]{"OOELS","OOOOO","OOOOO","OOOOO","OOOOO"}));
    }
}