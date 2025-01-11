package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BabyBabbleTest {

    @Test
    public void test() {
        BabyBabble babyBabble = new BabyBabble();
        Assertions.assertEquals(1, babyBabble.solution(new String[]{"aya", "yee", "u", "maa"}));
        Assertions.assertEquals(1, babyBabble.solution(new String[]{"ayamaaya"}));
        Assertions.assertEquals(0, babyBabble.solution(new String[]{"yayae"}));
    }
}