package tmapMobility.p2025;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(new Solution3().solution(new int[]{2, 4, 1, 3, 4, 6, 2, 4, 1, 6}));
    }

    public static boolean isValid(int[] array, int k) {
        int length = array.length / 2;
        int rightPrev;
        if ((k & 1) == 0) {
            rightPrev = array[1];
        } else {
            rightPrev = array[0];
        }

        for (int i = 1; i < length; i++) {
            boolean flip = (k >> i & 1) == 0;
            int left;
            int right;
            if (flip) {
                left = array[2 * i];
                right = array[2 * i + 1];
            } else {
                left = array[2 * i + 1];
                right = array[2 * i];
            }
            if (rightPrev != left) {
                return false;
            }
            rightPrev = right;
        }
        return true;
    }

    public int solution(int[] A) {
        int length = A.length;
        int eventCount = 1 << (length / 2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < eventCount; i++) {
            if (isValid(A, i)) {
                int flips = Integer.bitCount(i);
                if (flips < min) {
                    min = flips;
                }
            }
        }
        return min;
    }
}
