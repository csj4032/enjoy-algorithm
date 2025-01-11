package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BabyBabbleTest {

    @Test
    public void test() {
        BabyBabble babyBabble = new BabyBabble();
        //Assertions.assertEquals(1, babyBabble.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
        Assertions.assertEquals(3, babyBabble.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
    }
}