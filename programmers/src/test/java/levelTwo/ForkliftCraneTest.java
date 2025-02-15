package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForkliftCraneTest {

    @Test
    public void test() {
        ForkliftCrane forkliftCrane = new ForkliftCrane();
        Assertions.assertEquals(11, forkliftCrane.solution(new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[]{"A", "BB", "A"}));
        Assertions.assertEquals(4, forkliftCrane.solution(new String[]{"HAH", "HBH", "HHH", "HAH", "HBH"}, new String[]{"C", "B", "B", "B", "B", "H"}));
    }
}