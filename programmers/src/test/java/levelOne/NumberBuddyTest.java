package levelOne;

import org.junit.jupiter.api.Test;

class NumberBuddyTest {

    @Test
    public void test() {
        NumberBuddy numberBuddy = new NumberBuddy();
        System.out.println(numberBuddy.solution("100", "2345"));
        System.out.println(numberBuddy.solution("100", "203045"));
        System.out.println(numberBuddy.solution("100", "123450"));
        System.out.println(numberBuddy.solution("12321", "42531"));
        System.out.println(numberBuddy.solution("5525", "1255"));
    }
}