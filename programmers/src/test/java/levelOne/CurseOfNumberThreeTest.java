package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CurseOfNumberThreeTest {

    @Test
    public void test() {
        CurseOfNumberThree curseOfNumberThree = new CurseOfNumberThree();
        Assertions.assertEquals(25,curseOfNumberThree.solution(15));
        Assertions.assertEquals(76,curseOfNumberThree.solution(40));
    }
}