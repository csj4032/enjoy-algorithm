package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DividingNumberCardsTest {

    @Test
    public void test() {
        DividingNumberCards dividingNumberCards = new DividingNumberCards();
        Assertions.assertEquals(0, dividingNumberCards.solution(new int[]{10, 17}, new int[]{5, 20}));
        Assertions.assertEquals(10, dividingNumberCards.solution(new int[]{10, 20}, new int[]{5, 17}));
    }
}