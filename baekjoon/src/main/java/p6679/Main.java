package p6679;

/**
 * 제목 : 싱기한 네자리 숫자
 * 링크 : https://www.acmicpc.net/problem/6679
 * 분류 : 브루트 포스, 입문용
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 1000; i < 10000; i++) {
            String a = Integer.toString(i, 10);
            String b = Integer.toString(i, 12);
            String c = Integer.toString(i, 16);
            if (digitSum(a, 10) == digitSum(b, 12) && digitSum(a, 10) == digitSum(c, 16) && digitSum(b, 12) == digitSum(c, 16)) {
                System.out.println(a);
            }
        }
    }

    private static int digitSum(String digital, int radix) {
        int sum = 0;
        for (int i = 0; i < digital.length(); i++) {
            sum += Integer.parseInt(String.valueOf(digital.charAt(i)), radix);
        }
        return sum;
    }
}