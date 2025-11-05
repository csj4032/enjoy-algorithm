package levelTwo;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/148652">유사 칸토어 비트열</a>
 * Category : 재귀와 분할 정복, 5진법
 */
public class CantorLikeBitSequence {

    public int solution(int n, long l, long r) {
        return countOnes(n, l - 1, r - 1);
    }

    private int countOnes(int level, long left, long right) {
        if (level == 0) return 1;
        long blockSize = (long) Math.pow(5, level - 1);
        long onesPerBlock = (long) Math.pow(4, level - 1);
        int count = 0;
        for (int block = 0; block < 5; block++) {
            long blockStart = block * blockSize;
            long blockEnd = blockStart + blockSize - 1;
            if (blockEnd < left || blockStart > right) continue;
            if (block == 2) continue;
            if (left <= blockStart && blockEnd <= right) {
                count += onesPerBlock;
            } else {
                long newLeft = Math.max(0, left - blockStart);
                long newRight = Math.min(blockSize - 1, right - blockStart);
                count += countOnes(level - 1, newLeft, newRight);
            }
        }

        return count;
    }
}
