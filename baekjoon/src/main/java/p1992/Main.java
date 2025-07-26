package p1992;

import java.util.Scanner;

/**
 * 백준 1992번: 쿼드트리 (Silver 1)
 * https://www.acmicpc.net/problem/1992
 * 
 * 문제 분류: 분할정복, 재귀, 트리
 * 핵심 알고리즘: 분할정복으로 영역을 4등분하여 쿼드트리 생성
 * 
 * 해결 접근 방법:
 * 1. N×N 영역이 모두 같은 값(0 또는 1)으로 채워져 있는지 확인
 * 2. 같은 값이라면 해당 값을 반환 (압축 성공)
 * 3. 다른 값이 섞여있다면 4개 영역으로 분할하여 재귀 호출
 * 4. 4개 영역의 결과를 괄호로 묶어서 반환: (좌상)(우상)(좌하)(우하)
 * 
 * 시간복잡도: O(N²) - 최악의 경우 모든 칸을 한 번씩 방문
 * 공간복잡도: O(N²) - 영상 정보 저장 + 재귀 스택 O(log₂ N)
 * 
 * 쿼드트리 구조:
 * - 각 노드는 4개의 자식을 가질 수 있는 트리
 * - 영역을 4등분하여 재귀적으로 분할
 * - 압축 가능한 영역은 리프 노드가 됨
 * 
 * 분할 순서 (중요):
 * 1. 좌상 (x, y)
 * 2. 우상 (x, y + size/2)  
 * 3. 좌하 (x + size/2, y)
 * 4. 우하 (x + size/2, y + size/2)
 */
public class Main {

    static int N; // 영상 크기
    static char[][] image; // 영상 정보 (0 또는 1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        image = new char[N][N];

        // 영상 정보 입력
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                image[i][j] = line.charAt(j);
            }
        }
        
        // 쿼드트리 생성 및 출력
        System.out.println(buildQuadTree(0, 0, N));
        sc.close();
    }

    /**
     * 쿼드트리를 생성하는 재귀 함수
     * 
     * @param startRow 시작 행
     * @param startCol 시작 열
     * @param size 현재 영역의 크기
     * @return 쿼드트리 문자열 표현
     */
    private static String buildQuadTree(int startRow, int startCol, int size) {
        // Base case: 크기가 1이면 해당 픽셀값 반환
        if (size == 1) {
            return String.valueOf(image[startRow][startCol]);
        }
        
        // 4개 영역으로 분할하여 재귀 호출
        int halfSize = size / 2;
        String topLeft = buildQuadTree(startRow, startCol, halfSize);                    // 좌상
        String topRight = buildQuadTree(startRow, startCol + halfSize, halfSize);       // 우상  
        String bottomLeft = buildQuadTree(startRow + halfSize, startCol, halfSize);     // 좌하
        String bottomRight = buildQuadTree(startRow + halfSize, startCol + halfSize, halfSize); // 우하

        // 4개 영역이 모두 같은 단일 값이면 압축 가능
        if (isSameValue(topLeft, topRight, bottomLeft, bottomRight)) {
            return topLeft; // 압축된 단일 값 반환
        } else {
            // 압축 불가능하면 괄호로 묶어서 반환
            return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
        }
    }
    
    /**
     * 4개 영역이 모두 같은 단일 값인지 확인
     * 
     * @param topLeft 좌상 영역 결과
     * @param topRight 우상 영역 결과  
     * @param bottomLeft 좌하 영역 결과
     * @param bottomRight 우하 영역 결과
     * @return 모두 같은 단일 값이면 true, 아니면 false
     */
    private static boolean isSameValue(String topLeft, String topRight, 
                                     String bottomLeft, String bottomRight) {
        // 모든 영역이 길이 1(단일 값)이고 서로 같은 값인지 확인
        return topLeft.length() == 1 && 
               topLeft.equals(topRight) && 
               topLeft.equals(bottomLeft) && 
               topLeft.equals(bottomRight);
    }
}