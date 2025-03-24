package levelFour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FourOperationsTest {

    @Test
    public void test() {
        FourOperations fourOperations = new FourOperations();
        assertEquals(1, fourOperations.solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
        // assertEquals(3, fourOperations.solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"}));
    }
}