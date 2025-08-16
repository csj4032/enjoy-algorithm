package levelTwo;

/**
 * Link: <a href="https://school.programmers.co.kr/learn/courses/30/lessons/160585">...</a>
 */
public class SingleTicTacToe {

    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        for (String s : board) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') oCount++;
                if (s.charAt(j) == 'X') xCount++;
            }
        }
        if (xCount > oCount || oCount > xCount + 1) return 0;
        boolean oWins = hasWon('O', board);
        boolean xWins = hasWon('X', board);
        if (oWins) {
            if (xWins || oCount != xCount + 1) return 0;
        }
        if (xWins) {
            if (oCount != xCount) return 0;
        }
        return 1;
    }

    private boolean hasWon(char player, String[] board) {
        for (int i = 0; i < 3; i++) if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) return true;
        for (int i = 0; i < 3; i++) if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) return true;
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) return true;
        return board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player;
    }
}
