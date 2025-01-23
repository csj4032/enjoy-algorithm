package levelOne;

public class NeighboringCell {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dy = new int[]{-1, 0, 1, 0};
        int[] dx = new int[]{0, 1, 0, -1};
        String color = board[h][w];
        int hh = board.length;
        int ww = board[0].length;
        for (int i = 0; i < 4; i++) {
            int ny = h - dy[i];
            int nx = w - dx[i];
            if (ny < 0 || nx < 0 || ny >= hh || nx >= ww) continue;
            if (color.equals(board[ny][nx])) answer++;
        }
        return answer;
    }
}
