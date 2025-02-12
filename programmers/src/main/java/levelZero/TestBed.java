package levelZero;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBed {

    public int solution(String my_string) {
        int sum = 0;
        Matcher matcher = Pattern.compile("\\d+").matcher(my_string);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        return sum;
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        int result = testBed.solution("aAb1B2cC34oOp");
        System.out.println(result);
    }
}