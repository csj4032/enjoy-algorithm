package levelZero;

import java.math.BigInteger;

public class TestBed {

    public int solution(int balls, int share) {
        if (share > balls) return 0;
        if (balls == share) return 1;
        return factorial(balls).divide(factorial(share).multiply(factorial(balls - share))).intValue();
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }


    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        testBed.solution(3, 2);
        testBed.solution(5, 3);
        System.out.println(testBed.solution(30, 4));
    }
}