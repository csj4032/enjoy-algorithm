package levelTwo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/340211">[PCCP 기출문제] 3번 / 충돌위험 찾기</a>
 * Category : Simulation
 * Describe :
 */
public class CollisionDetector {

    public int solution(int[][] points, int[][] routes) {
        AtomicInteger answer = new AtomicInteger(0);
        Map<Integer, Point> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) pointMap.put(i + 1, new Point(points[i][0], points[i][1]));
        List<List<Point>> routeList = new ArrayList<>();
        int maxRoute = 0;

        for (int[] route : routes) {
            List<Point> fullPath = new ArrayList<>();
            Point current = pointMap.get(route[0]);
            fullPath.add(current);

            for (int i = 1; i < route.length; i++) {
                Point target = pointMap.get(route[i]);
                fullPath.addAll(getPath(current, target).subList(1, getPath(current, target).size()));
                current = target;
            }
            routeList.add(fullPath);
            maxRoute = Math.max(maxRoute, fullPath.size());
        }

        for (int t = 0; t < maxRoute; t++) {
            List<Point> positions = new ArrayList<>();
            for (List<Point> path : routeList) {
                if (t < path.size()) positions.add(path.get(t));
            }
            Map<Point, Long> freqMap = positions.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
            long collisions = freqMap.values().stream().filter(count -> count > 1).count();
            answer.addAndGet((int) collisions);
        }

        return answer.get();
    }

    private List<Point> getPath(Point start, Point end) {
        List<Point> path = new ArrayList<>();
        Point current = start;
        path.add(current);

        while (current.row != end.row) {
            current = new Point(current.row + (end.row > current.row ? 1 : -1), current.col);
            path.add(current);
        }
        while (current.col != end.col) {
            current = new Point(current.row, current.col + (end.col > current.col ? 1 : -1));
            path.add(current);
        }
        return path;
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Point{" + "row=" + row + ", col=" + col + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return row == point.row && col == point.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
