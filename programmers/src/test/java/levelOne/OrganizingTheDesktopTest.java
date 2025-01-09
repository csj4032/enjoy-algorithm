package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrganizingTheDesktopTest {

    @Test
    public void test() {
        OrganizingTheDesktop organizingTheDesktop = new OrganizingTheDesktop();
        Assertions.assertArrayEquals(new int[]{0, 1, 3, 4}, organizingTheDesktop.solution(new String[]{".#...", "..#..", "...#."}));
        Assertions.assertArrayEquals(new int[]{1, 3, 5, 8}, organizingTheDesktop.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."}));
        Assertions.assertArrayEquals(new int[]{0, 0, 7, 9}, organizingTheDesktop.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}));
        Assertions.assertArrayEquals(new int[]{1, 0, 2, 1}, organizingTheDesktop.solution(new String[]{"..", "#."}));
    }
}