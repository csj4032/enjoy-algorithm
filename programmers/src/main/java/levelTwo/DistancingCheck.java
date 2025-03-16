package levelTwo;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/81302
 * Category : Simulation, 시뮬레이션
 */
public class DistancingCheck {

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static final int[] dxDiag = {1, 1, -1, -1};
    private static final int[] dyDiag = {1, -1, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) answer[i] = isDistancing(places[i]) ? 1 : 0;
        return answer;
    }

    private boolean isDistancing(String[] place) {
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    if (!isSafe(map, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] map, int i, int j) {
        for (int d = 0; d < 4; d++) {
            int ny = i + dy[d];
            int nx = j + dx[d];
            if (isValid(ny, nx) && map[ny][nx] == 'P') return false;

            int nny = i + 2 * dy[d];
            int nnx = j + 2 * dx[d];
            if (isValid(nny, nnx) && map[nny][nnx] == 'P' && map[ny][nx] != 'X') return false;
        }

        for (int d = 0; d < 4; d++) {
            int ny = i + dyDiag[d];
            int nx = j + dxDiag[d];
            if (isValid(ny, nx) && map[ny][nx] == 'P') if (map[i][nx] != 'X' || map[ny][j] != 'X') return false;
        }

        return true;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < 5 && j < 5;
    }
}
