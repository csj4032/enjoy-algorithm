package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MineMineralsTest {

    @Test
    public void test() {
        MineMinerals mineMinerals = new MineMinerals();
        //assertEquals(12, mineMinerals.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
        assertEquals(50, mineMinerals.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }
}