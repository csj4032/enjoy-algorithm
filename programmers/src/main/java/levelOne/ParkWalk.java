package levelOne;

public class ParkWalk {

    public int[] solution(String[] park, String[] routes) {
        int height = park.length, width = park[0].length();
        boolean[][] map = new boolean[height][width];
        int x = 0, y = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char cell = park[i].charAt(j);
                map[i][j] = (cell != 'X');
                if (cell == 'S') {
                    x = j;
                    y = i;
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            Integer distance = Integer.parseInt(parts[1]);
            int sx = x, sy = y;
            for (int i = 0; i < distance; i++) {
                if (direction.equals("E")) sx++;
                if (direction.equals("W")) sx--;
                if (direction.equals("N")) sy--;
                if (direction.equals("S")) sy++;
                if (sx < 0 || sx >= width || sy < 0 || sy >= height || !map[sy][sx]) {
                    sx = x;
                    sy = y;
                    break;
                }
            }
            x = sx;
            y = sy;
        }
        return new int[]{y, x};
    }
}
