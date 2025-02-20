package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StickerCollectionTest {

    @Test
    public void test() {
        StickerCollection stickerCollection = new StickerCollection();
        Assertions.assertEquals(1, stickerCollection.solution(new int[]{1}));
        Assertions.assertEquals(36, stickerCollection.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        Assertions.assertEquals(8, stickerCollection.solution(new int[]{1, 3, 2, 5, 4}));
    }
}