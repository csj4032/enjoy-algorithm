package levelZero;

public class CalculateRectangle {
    public int solution(int[][] dots) {
        int x1 = dots[0][0];
        int y1 = dots[0][1];
        int x2 = dots[1][0];
        int y2 = dots[1][1];
        int x3 = dots[2][0];
        int y3 = dots[2][1];
        int x4 = dots[3][0];
        int y4 = dots[3][1];
        int xx = Math.max(Math.max(x1, x2), Math.max(x3, x4));
        int xm = Math.min(Math.min(x1, x2), Math.min(x3, x4));
        int yx = Math.max(Math.max(y1, y2), Math.max(y3, y4));
        int ym = Math.min(Math.min(y1, y2), Math.min(y3, y4));
        int width = Math.abs(xx - xm);
        int height = Math.abs(yx - ym);
        return width * height;
    }
}