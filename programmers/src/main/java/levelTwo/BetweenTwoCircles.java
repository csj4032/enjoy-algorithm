package levelTwo;

public class BetweenTwoCircles {

    public long solution(int r1, int r2) {
        long inner = 0;
        long outer = 0;
        long c1 = r1 * r1;
        long c2 = r2 * r2;
        for (long i = 0; i <= r1; i++) {
            long maxYSquared = c1 - i * i;
            inner += Math.sqrt(maxYSquared) + 1;
            System.out.println(inner);
        }

        for (long i = -r2; i < r2; i++) {
            long maxYSquared = c2 - i * i;
            outer += Math.sqrt(maxYSquared) + 1;
        }
        System.out.println(inner + " " + outer);
        return 0l;
    }
}
