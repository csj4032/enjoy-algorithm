package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigNumberTest {

    @Test
    public void test() {
        BigNumber bigNumber = new BigNumber();
        Assertions.assertEquals("94", bigNumber.solution("1924", 2));
        Assertions.assertEquals("3234", bigNumber.solution("1231234", 3));
        Assertions.assertEquals("775841", bigNumber.solution("4177252841", 4));
    }
}