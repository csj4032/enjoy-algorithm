package levelOne;

public class Park {
    public int solution(int[] mats, String[][] park) {
        int height = park.length;
        int width = park[0].length;
        int length = height * width;
        int max = 0;
        for (int mat : mats) {
            for (int i = 0; i < length; i++) {
                int sy = i / height;
                int sx = i % width;
                int ey = sy + mat;
                int ex = sx + mat;
                if (ey > height || ex > width) continue;
                if (promise(sy, sx, ey, ex, park)) {
                    max = Math.max(max, mat);
                }
            }
        }
        return max;
    }

    private boolean promise(int sy, int sx, int ey, int ex, String[][] park) {
        for (int i = sy; i < ey; i++) {
            for (int j = sx; j < ex; j++) {
                if (!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}
