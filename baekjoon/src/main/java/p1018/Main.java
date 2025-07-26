package p1018;

import java.util.Scanner;

/**
 * 제목 : 체스판 다시 칠하기
 * 링크 : https://www.acmicpc.net/problem/1018
 * 분류 : 브루트포스 알고리즘
 * 
 * 문제 해설:
 * - N×M 보드에서 8×8 체스판을 만들기 위해 다시 칠해야 하는 정사각형의 최소 개수를 구하는 문제
 * - 체스판은 검은색(B)과 흰색(W)이 번갈아 나타나는 패턴
 * - 두 가지 패턴 가능: 맨 왼쪽 위가 W인 경우와 B인 경우
 * 
 * 해결 방법:
 * - 모든 가능한 8×8 영역에 대해 완전탐색 (브루트포스)
 * - 각 영역에서 두 가지 체스판 패턴과 비교
 * - (i+j)가 짝수/홀수에 따라 체스판 색깔 결정
 * - 두 패턴 중 더 적게 칠하는 횟수를 선택
 * 
 * 시간복잡도: O((N-7)×(M-7)×64) = O(N×M)
 * 공간복잡도: O(N×M)
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 보드의 세로 크기
        int m = sc.nextInt();  // 보드의 가로 크기
        
        // 보드 입력받기
        char[][] board = initBoard(sc, n, m);
        
        // 모든 8×8 영역에 대해 브루트포스 탐색
        System.out.println(brute(n - 8, m - 8, board));
    }

    /**
     * 보드 초기화 및 입력받기
     */
    private static char[][] initBoard(Scanner sc, int n, int m) {
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                chars[i][j] = line.charAt(j);
            }
        }
        return chars;
    }

    /**
     * 모든 가능한 8×8 영역에서 최소 칠하기 횟수 찾기
     * @param maxRow 가능한 시작 행의 최대값 (n-8)
     * @param maxCol 가능한 시작 열의 최대값 (m-8)
     * @param chars 입력받은 보드
     */
    private static int brute(int maxRow, int maxCol, char[][] chars) {
        int minCount = Integer.MAX_VALUE;
        
        // 모든 가능한 8×8 영역에 대해 탐색
        for (int i = 0; i <= maxRow; i++) {
            for (int j = 0; j <= maxCol; j++) {
                minCount = Math.min(countRepaints(i, j, chars), minCount);
            }
        }
        return minCount;
    }

    /**
     * 특정 8×8 영역에서 체스판을 만들기 위한 최소 칠하기 횟수 계산
     * @param startRow 시작 행
     * @param startCol 시작 열
     * @param chars 보드 배열
     */
    private static int countRepaints(int startRow, int startCol, char[][] chars) {
        int whiteFirst = 0;  // 맨 왼쪽 위가 흰색인 패턴
        int blackFirst = 0;  // 맨 왼쪽 위가 검은색인 패턴
        
        char[] pattern = {'W', 'B'};  // 체스판 패턴
        
        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                // (i+j)가 짝수면 첫 번째 색, 홀수면 두 번째 색
                char expectedColor = pattern[(i + j) % 2];
                
                if (expectedColor == chars[i][j]) {
                    whiteFirst++;  // W로 시작하는 패턴에서 일치
                } else {
                    blackFirst++;  // B로 시작하는 패턴에서 일치
                }
            }
        }
        
        // 64 - 일치하는 개수 = 칠해야 하는 개수
        // 두 패턴 중 더 적게 칠하는 것을 선택
        return Math.min(64 - whiteFirst, 64 - blackFirst);
    }
}
