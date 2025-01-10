package levelZero;

public class SafeZone {

    public int solution(int[][] board) {
        int answer = 0;
        int row = board.length;
        int col = board.length;

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int nx = dx[k] + j;
                        int ny = dy[k] + j;
                        if (nx >= 0 && ny >= 0 && nx < row && ny < col && board[nx][ny] == 0) {
                            board[i][j] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}
