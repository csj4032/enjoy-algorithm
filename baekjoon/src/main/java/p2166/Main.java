package p2166;

import java.util.*;

/**
 * 제목 : 다각형의 면적 - Shoelace Formula (Gauss Area Formula)
 * 링크 : https://www.acmicpc.net/problem/2166
 * 분류 : 기하학, 계산기하학
 * 난이도 : Gold V
 * 
 * ========================================================================
 * ■ 문제 개요 및 핵심 개념
 * ========================================================================
 * 
 * 2차원 평면에서 N개의 점으로 이루어진 다각형의 넓이를 구하는 문제입니다.
 * 신발끈 공식(Shoelace Formula) 또는 가우스 면적 공식을 사용합니다.
 * 
 * ★ 신발끈 공식:
 * Area = (1/2) × |∑(xᵢyᵢ₊₁ - xᵢ₊₁yᵢ)| (i = 0 to n-1, 인덱스는 모듈로 n)
 * 
 * ★ 핵심 아이디어:
 * - 다각형의 꼭짓점들이 시계방향 또는 반시계방향으로 주어짐
 * - 벡터의 외적을 이용한 면적 계산
 * - 부호를 고려하여 절댓값 취하기
 * 
 * ★ 수학적 원리:
 * - 원점에서 각 변까지의 삼각형 면적들의 합
 * - 시계방향이면 음수, 반시계방향이면 양수
 * - 최종적으로 절댓값을 취해 실제 면적 계산
 * 
 * 시간복잡도: O(N)
 * 공간복잡도: O(N)
 */
public class Main {
    
    static class Point {
        long x, y;
        
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        Point[] points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            points[i] = new Point(x, y);
        }
        
        double area = calculatePolygonArea(points);
        System.out.printf("%.1f\n", area);
    }
    
    /**
     * 신발끈 공식을 이용한 다각형 넓이 계산
     */
    private static double calculatePolygonArea(Point[] points) {
        int n = points.length;
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            sum += points[i].x * points[next].y - points[next].x * points[i].y;
        }
        
        return Math.abs(sum) / 2.0;
    }
}