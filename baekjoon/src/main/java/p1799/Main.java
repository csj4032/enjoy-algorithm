package p1799;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static List<int[]> position = new ArrayList<>();
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    position.add(new int[]{i, j});
                }
            }
        }
        bishop(0, 0);
        System.out.println(m);
    }

    private static void bishop(int k, int cnt) {
        if (position.size() == k) {
            m++;
            return;
        }
        if (promising(position.get(k)[0], position.get(k)[1])) {
            visited[position.get(k)[0]][position.get(k)[1]] = true;
            bishop(k + 1, cnt+1);
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(visited[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean promising(int y, int x) {
        int p1 = Math.max(y, x);
        for (int i = 1; i < n - p1; i++) {
            //System.out.println("1 y = " + (y + i) + " x = " + (x + i));
            if (visited[y + i][x + i] == true) {
                return false;
            }
        }
        int p2 = Math.min(y, x);
        for (int i = 1; i <= p2; i++) {
            //System.out.println("2 y = " + (y - i) + " x = " + (x - i));
            if (visited[y - i][x - i] == true) {
                return false;
            }
        }

        int p3 = Math.min(n - y, x);
        for (int i = 1; i <= p3; i++) {
            //System.out.println("3 y = " + (y + i) + " x = " + (x - i));
            if (visited[y + i][x - i] == true) {
                return false;
            }
        }

        int p4 = Math.min(y, n - x);
        for (int i = 1; i <= p4; i++) {
            //System.out.println("4 y = " + (y - i) + " x = " + (x + i));
            if (visited[y - i][x + i] == true) {
                return false;
            }
        }
        return true;
    }
}
