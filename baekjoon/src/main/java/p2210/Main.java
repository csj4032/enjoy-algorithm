package p2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 제목 : 숫자판 점프
 * 링크 : https://www.acmicpc.net/problem/2210
 */
public class Main {

    static int m[][] = new int[5][5];
    static int l[] = new int[6];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                jump(0, i, j);
            }
        }
        System.out.println(list.size());
    }

    private static void jump(int count, int x, int y) {
        if (count == 6) {
            if (!list.contains(Arrays.toString(l))) {
                list.add(Arrays.toString(l));
            }
            return;
        }
        l[count] = m[x][y];
        if (y > 0) jump(count + 1, x, y - 1);
        if (x < 4) jump(count + 1, x + 1, y);
        if (y < 4) jump(count + 1, x, y + 1);
        if (x > 0) jump(count + 1, x - 1, y);
    }
}
