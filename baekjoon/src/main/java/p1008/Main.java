package p1008;

import java.util.Scanner;

/**
 * 백준 1008번 - A/B
 * https://www.acmicpc.net/problem/1008
 * 
 * 난이도: Bronze V
 * 분류: 수학, 구현, 사칙연산
 * 
 * 프로그래밍 기초 개념:
 * 1. 실수 자료형 (double) - 소수점이 있는 수를 저장
 * 2. 정수 나눗셈 vs 실수 나눗셈의 차이점
 * 3. 형변환 (Type Casting) - int를 double로 변환
 * 4. 부동소수점 연산의 이해
 * 
 * 문제 핵심:
 * - 정수 A, B를 입력받아 A/B의 실수 결과를 출력
 * - 정수끼리 나누면 정수가 나오므로, 실수 나눗셈이 필요
 * 
 * 초보자를 위한 팁:
 * - int / int = int (정수 나눗셈: 7/3 = 2)
 * - double / double = double (실수 나눗셈: 7.0/3.0 = 2.333...)
 * - 적어도 하나가 실수면 실수 나눗셈이 됩니다
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 두 정수를 입력받습니다
        // 문제에서는 정수를 입력하지만, 실수 나눗셈을 위해 double로 받습니다
        double A = sc.nextDouble(); // 첫 번째 수 (실수로 저장)
        double B = sc.nextDouble(); // 두 번째 수 (실수로 저장)
        
        // 실수 나눗셈 수행 및 출력
        // A와 B가 모두 double이므로 실수 나눗셈이 됩니다
        System.out.println(A / B);
        
        sc.close();
    }
}

/*
 * 다른 방법들:
 * 
 * 방법 1: 정수로 입력받고 형변환
 * int a = sc.nextInt();
 * int b = sc.nextInt(); 
 * System.out.println((double)a / b); // a를 double로 형변환
 * 
 * 방법 2: 하나만 실수로 만들기
 * int a = sc.nextInt();
 * int b = sc.nextInt();
 * System.out.println(a * 1.0 / b); // a에 1.0을 곱해 실수로 만들기
 * 
 * 방법 3: 직접 실수로 입력받기 (현재 코드)
 * double a = sc.nextDouble();
 * double b = sc.nextDouble();
 * System.out.println(a / b);
 */

/*
 * 학습 가이드:
 * 
 * 1. 자료형별 나눗셈 차이
 *    - int ÷ int = int (소수점 버림)
 *      예: 7 ÷ 3 = 2 (나머지 1은 버려짐)
 *    - double ÷ double = double (정확한 실수값)
 *      예: 7.0 ÷ 3.0 = 2.333333...
 * 
 * 2. 형변환 (Type Casting)
 *    - (double)a: a를 double로 강제 형변환
 *    - a * 1.0: 곱셈으로 자동 형변환 유도
 *    - 더 큰 자료형으로 자동 변환됩니다
 * 
 * 3. 부동소수점 주의사항
 *    - 실수는 정확하지 않을 수 있습니다 (근사값)
 *    - 매우 작은 차이가 생길 수 있습니다
 *    - 이진수로 저장되어 십진수와 약간 다를 수 있습니다
 * 
 * 4. 실습해보기
 *    - 7 ÷ 3을 정수와 실수로 각각 계산해보세요
 *    - 1 ÷ 3의 결과를 관찰해보세요
 *    - 큰 수와 작은 수의 나눗셈도 테스트해보세요
 * 
 * 5. 활용 분야
 *    - 평균 계산 (합계 ÷ 개수)
 *    - 비율 계산 (부분 ÷ 전체)  
 *    - 속도 계산 (거리 ÷ 시간)
 */