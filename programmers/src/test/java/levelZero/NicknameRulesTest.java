package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NicknameRulesTest {

    @Test
    public void test() {
        NicknameRules nicknameRules = new NicknameRules();
        Assertions.assertEquals("G0oo", nicknameRules.solution("GO"));
    }
}