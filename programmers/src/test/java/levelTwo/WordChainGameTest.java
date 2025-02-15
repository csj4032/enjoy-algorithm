package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordChainGameTest {

    @Test
    public void test() {
        WordChainGame wordChainGame = new WordChainGame();
        Assertions.assertArrayEquals(new int[]{3, 3}, wordChainGame.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
        Assertions.assertArrayEquals(new int[]{0, 0}, wordChainGame.solution(5,
                new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
        Assertions.assertArrayEquals(new int[]{1, 3}, wordChainGame.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));
    }
}