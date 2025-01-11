package levelOne;

import org.junit.jupiter.api.Test;

class SecretCodeBetweenTwoTest {

    @Test
    public void test() {
        SecretCodeBetweenTwo secretCodeBetweenTwo = new SecretCodeBetweenTwo();
        // cdefghijklmnopqrstuvwxyzb
        // cdefghijklmnopqrstuvwxyzb
        secretCodeBetweenTwo.solution("bcdefghijklmnopqrstuvwxyz", "a", 1);
    }
}