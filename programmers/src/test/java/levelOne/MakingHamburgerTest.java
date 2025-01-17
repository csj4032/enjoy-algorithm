package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MakingHamburgerTest {

    @Test
    public void test() {
        MakingHamburger makingHamburger = new MakingHamburger();
        Assertions.assertEquals(2, makingHamburger.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        Assertions.assertEquals(0, makingHamburger.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
}