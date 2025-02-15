package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountEventTest {

    @Test
    public void test() {
        DiscountEvent discountEvent = new DiscountEvent();
        Assertions.assertEquals(3, discountEvent.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{
                "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"
        }));
        Assertions.assertEquals(0, discountEvent.solution(new String[]{"apple"}, new int[]{10}, new String[]{
                "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"
        }));
    }
}