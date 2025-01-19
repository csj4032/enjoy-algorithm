package levelZero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBed {

    public String[] solution(String my_string) {
        return my_string.trim().split(" +");
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        String[] result = testBed.solution(" i    love  you");
        System.out.println(result);
    }
}