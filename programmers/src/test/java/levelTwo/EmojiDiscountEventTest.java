package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmojiDiscountEventTest {

    @Test
    public void solution() {
        EmojiDiscountEvent emojiDiscountEvent = new EmojiDiscountEvent();
        assertArrayEquals(new int[]{1, 5400}, emojiDiscountEvent.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000}));
        assertArrayEquals(new int[]{4, 13860}, emojiDiscountEvent.solution(new int[][]{{40, 2900}, {25, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, new int[]{1300, 1500, 1600, 4900}));
    }
}