package p2003;

/**
 * 제목 : 수들의 합 2
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] m = new int[10001];

        for (int i = 0; i < n; i++) m[i] = sc.nextInt();

        int left = 0;
        int right = 0;
        int sum = m[0];
        int count = 0;

        while (true) {
            if (sum < t) {
                if (right < n) {
                    sum += m[++right];
                } else {
                    break;
                }
            } else if (sum == t) {
                count++;
                sum -= m[left++];
            } else {
                sum -= m[left++];
            }
        }

        System.out.println(count);
    }
}