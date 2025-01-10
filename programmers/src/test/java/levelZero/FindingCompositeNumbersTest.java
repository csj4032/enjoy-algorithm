package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindingCompositeNumbersTest {

    @Test
    public void test(){
        FindingCompositeNumbers findingCompositeNumbers = new FindingCompositeNumbers();
        Assertions.assertEquals(5, findingCompositeNumbers.solution(10));
        Assertions.assertEquals(8, findingCompositeNumbers.solution(15));
    }
}