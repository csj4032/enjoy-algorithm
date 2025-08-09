package p1193;

import java.util.Scanner;

/**
 * 백준 1193번 - 분수찾기
 * https://www.acmicpc.net/problem/1193
 * 
 * 난이도: Bronze I
 * 분류: 수학, 구현
 * 
 * 프로그래밍 기초 개념:
 * 1. 패턴 인식과 규칙 찾기
 * 2. 수열과 누적합 개념
 * 3. 조건문을 이용한 홀짝 판별
 * 4. while 반복문과 break 사용
 * 
 * 수학 개념:
 * - 분수의 지그재그 배열 패턴
 * - 대각선별 분수 개수: 1, 2, 3, 4, ...
 * - 분자와 분모의 증감 규칙
 * - 누적합으로 구간 찾기
 * 
 * 초보자를 위한 팁:
 * - 분수들이 대각선 형태로 배열되어 있다고 생각해보세요
 * - 홀수 번째 대각선과 짝수 번째 대각선의 방향이 반대입니다
 * - 표를 그려서 패턴을 확인해보는 것이 중요합니다!
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(); // 찾고자 하는 분수의 순서 (1부터 시작)
        
        // X번째 분수가 몇 번째 대각선에 있는지 찾기
        int diagonal = 1;        // 현재 확인하는 대각선 번호
        int totalCount = 0;      // 현재 대각선까지의 총 분수 개수
        
        // X가 속한 대각선을 찾을 때까지 반복
        while (totalCount < X) {
            totalCount += diagonal; // diagonal번째 대각선에는 diagonal개의 분수가 있음
            if (totalCount >= X) {
                break; // X번째 분수가 현재 대각선에 있음
            }
            diagonal++; // 다음 대각선으로
        }
        
        // 현재 대각선에서 몇 번째 위치인지 계산
        int positionInDiagonal = X - (totalCount - diagonal);
        
        int numerator;   // 분자
        int denominator; // 분모
        
        if (diagonal % 2 == 1) {
            // 홀수 번째 대각선: 위에서 아래로 (분자 감소, 분모 증가)
            // 첫 번째: diagonal/1, 두 번째: (diagonal-1)/2, ...
            numerator = diagonal - positionInDiagonal + 1;
            denominator = positionInDiagonal;
        } else {
            // 짝수 번째 대각선: 아래에서 위로 (분자 증가, 분모 감소)
            // 첫 번째: 1/diagonal, 두 번째: 2/(diagonal-1), ...
            numerator = positionInDiagonal;
            denominator = diagonal - positionInDiagonal + 1;
        }
        
        System.out.println(numerator + "/" + denominator);
        
        sc.close();
    }
}

/*
 * 학습 가이드:
 * 
 * 1. 분수 배열의 패턴 이해
 *    지그재그로 배열된 분수들:
 *    
 *    대각선 1: 1/1
 *    대각선 2: 1/2, 2/1  
 *    대각선 3: 3/1, 2/2, 1/3
 *    대각선 4: 1/4, 2/3, 3/2, 4/1
 *    대각선 5: 5/1, 4/2, 3/3, 2/4, 1/5
 *    
 *    각 대각선의 분수 개수: 1, 2, 3, 4, 5, ...
 * 
 * 2. 대각선 방향의 규칙
 *    - 홀수 번째 대각선: 오른쪽 위에서 왼쪽 아래로
 *      분자는 큰 수부터 작은 수로, 분모는 작은 수부터 큰 수로
 *    - 짝수 번째 대각선: 왼쪽 아래에서 오른쪽 위로  
 *      분자는 작은 수부터 큰 수로, 분모는 큰 수부터 작은 수로
 * 
 * 3. 누적합으로 구간 찾기
 *    - 1번째부터 n번째 대각선까지의 총 분수 개수: 1+2+3+...+n = n(n+1)/2
 *    - X번째 분수가 어느 대각선에 있는지 찾기 위해 누적합 사용
 * 
 * 4. 대각선 내 위치 계산
 *    - 전체 순서에서 이전 대각선들의 분수 개수를 뺀 값
 *    - positionInDiagonal = X - (이전 대각선들의 총 개수)
 * 
 * 5. 분자/분모 계산 공식
 *    n번째 대각선에서 k번째 위치의 분수:
 *    - 홀수 대각선: (n-k+1)/k
 *    - 짝수 대각선: k/(n-k+1)
 * 
 * 6. 실습해보기
 *    - X=1: 1/1 (1번째 대각선의 1번째)
 *    - X=2: 1/2 (2번째 대각선의 1번째)  
 *    - X=3: 2/1 (2번째 대각선의 2번째)
 *    - X=4: 3/1 (3번째 대각선의 1번째)
 *    - X=5: 2/2 (3번째 대각선의 2번째)
 * 
 * 7. 다른 접근 방법
 *    - 수학 공식 사용: n번째 대각선까지의 합이 n(n+1)/2
 *    - 이차방정식을 풀어서 직접 대각선 번호 계산 가능
 *    - 하지만 반복문이 더 직관적이고 이해하기 쉬움
 * 
 * 8. 실생활 응용
 *    - 행렬의 대각선 순회
 *    - 2차원 배열을 1차원으로 변환
 *    - 지그재그 패턴의 데이터 처리
 *    - 이미지 처리에서의 픽셀 순회
 */