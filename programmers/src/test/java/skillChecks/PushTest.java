package skillChecks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    @Test
    public void test() {
        Push push = new Push();
        Assertions.assertEquals("BC", push.solution("AB", 1));
        Assertions.assertEquals("a", push.solution("z", 1));
        Assertions.assertEquals("e F d", push.solution("a B z", 4));
    }
}