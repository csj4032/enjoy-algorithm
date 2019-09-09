package p11729;

import java.util.Scanner;

/**
 * 제목 : 하노이 탑 이동 순서
 * 링크 : https://www.acmicpc.net/problem/11729
 * 분류 : 분할정복
 * 메모 : 한 번에 하나의 원판만 옮길 수 있다. 큰 원판이 작은 원판 위에 있어서는 안 된다. n 이 to 에서 from 가려면 n-1은 previous에 있어여 한다.
 */
public class Main {

    static int k = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n, 1, 3, 2);
        sb.insert(0, k + "\n");
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int from, int to, int pre) {
        if (n == 1) {
            k++;
            sb.append(from + " " + to + "\n");
            return;
        }
        hanoi(n - 1, from, pre, to);
        k++;
        sb.append(from + " " + to + "\n");
        hanoi(n - 1, pre, to, from);
    }
}
