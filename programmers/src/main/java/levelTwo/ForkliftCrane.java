package levelTwo;

public class ForkliftCrane {

    static int row = 0;
    static int col = 0;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        row = storage.length;
        col = storage[0].length();
        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) board[i] = storage[i].toCharArray();

        for (String request : requests) {
            char target = request.charAt(0);
            boolean isCrane = request.length() == 2 ? true : false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (target == board[i][j]) {
                        if (isCrane) {
                            board[i][j] = '1';
                        } else {
                            if (isOnBorder(i, j)) {
                                board[i][j] = '1';
                                continue;
                            }
                            if (isAdjacentEmpty(board,i, j)) {
                                board[i][j] = '1';
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == '1') {
                        if (dfs(board, i, j, new boolean[row][col])) board[i][j] = '\u0000';
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1') board[i][j] = '\u0000';
                if (board[i][j] != '\u0000') answer++;
            }
        }
        return answer;
    }

    private boolean isOnBorder(int i, int j) {
        return (i == 0 || i == row - 1 || j == 0 || j == col - 1);
    }

    private boolean isAdjacentEmpty(char[][] board, int i, int j) {
        return (board[i - 1][j] == '\u0000' || board[i + 1][j] == '\u0000'
                || board[i][j - 1] == '\u0000' || board[i][j + 1] == '\u0000');
    }

    private static boolean dfs(char[][] board, int r, int c, boolean[][] visited) {
        if (r + 1 == row || c + 1 == col) return true;
        if (r == 0 || c == 0) return true;
        visited[r][c] = true;
        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (nr >= 0 && nr < row && nc >= 0 && nc < col && (board[nr][nc] == '\u0000' || board[nr][nc] == '1') && !visited[nr][nc]) {
                if (dfs(board, nr, nc, visited)) return true;
            }
        }
        return false;
    }
}
