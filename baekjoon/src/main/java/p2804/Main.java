package p2804;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static char[][] board = new char[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String a = sc.next();
        String b = sc.next();

        for (int i = 0; i < 30; i++) Arrays.fill(board[i], '.');

        int c = 0;
        int r = 0;
        label1:
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    c = i;
                    r = j;
                    break label1;
                }
            }
        }

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (i == c) {
                    board[j][i] = b.charAt(j);
                } else if (j == r) {
                    board[j][i] = a.charAt(i);
                }
            }
        }

        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
