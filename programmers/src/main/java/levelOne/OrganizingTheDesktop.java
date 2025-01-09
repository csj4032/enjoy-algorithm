package levelOne;

import java.util.Scanner;

public class OrganizingTheDesktop {

    public int[] solution(String[] wallpaper) {
        int height = wallpaper.length, width = wallpaper[0].length();
        int lux = width, luy = height, rdx = 0, rdy = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char cell = wallpaper[i].charAt(j);
                if (cell == '#') {
                    if (luy > i) luy = i;
                    if (lux > j) lux = j;
                    if (rdy < i) rdy = i;
                    if (rdx < j) rdx = j;
                }
            }
        }
        return new int[]{luy, lux, rdy + 1, rdx + 1};
    }
}