package levelOne;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TheThreeMusketeersTest {

    @Test
    public void test() {
        TheThreeMusketeers theThreeMusketeers = new TheThreeMusketeers();
        Assertions.assertEquals(2, theThreeMusketeers.solution(new int[]{-2, 3, 0, 2, -5}));
        Assertions.assertEquals(5, theThreeMusketeers.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        Assertions.assertEquals(0, theThreeMusketeers.solution(new int[]{-1, 1, -1, 1}));
    }
}