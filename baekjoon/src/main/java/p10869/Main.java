package p10869;

import java.util.Scanner;

/**
 * 백준 10869번 - 사칙연산
 * https://www.acmicpc.net/problem/10869
 * 
 * 난이도: Bronze V
 * 분류: 사칙연산, 수학
 * 
 * 프로그래밍 기초 개념:
 * 1. 변수 (Variable) - 데이터를 저장하는 공간
 * 2. 입력 (Input) - Scanner를 이용한 사용자 입력
 * 3. 연산자 (Operators) - +, -, *, /, %
 * 4. 출력 (Output) - System.out.println()을 이용한 결과 출력
 * 
 * 초보자를 위한 팁:
 * - 자바에서 나눗셈(/)은 정수끼리 나누면 정수 결과만 반환됩니다
 * - 나머지 연산자(%)는 나눈 후 남은 나머지를 구할 때 사용합니다
 * - Scanner는 콘솔에서 입력을 받을 때 가장 기본적으로 사용하는 클래스입니다
 */
public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성 - 키보드 입력을 받기 위해
        // System.in은 표준 입력(키보드)을 의미합니다
        Scanner sc = new Scanner(System.in);
        
        // 두 정수 A, B를 입력받습니다
        // nextInt()는 다음 정수를 읽어옵니다
        int A = sc.nextInt(); // 첫 번째 정수 저장
        int B = sc.nextInt(); // 두 번째 정수 저장
        
        // 덧셈: 두 수를 더합니다
        System.out.println(A + B);
        
        // 뺄셈: 첫 번째 수에서 두 번째 수를 뺍니다
        System.out.println(A - B);
        
        // 곱셈: 두 수를 곱합니다
        System.out.println(A * B);
        
        // 나눗셈: 첫 번째 수를 두 번째 수로 나눈 몫
        // 정수끼리 나누면 소수점은 버려지고 정수 부분만 남습니다
        System.out.println(A / B);
        
        // 나머지: 첫 번째 수를 두 번째 수로 나눈 나머지
        // 예: 7 % 3 = 1 (7을 3으로 나누면 몫이 2, 나머지가 1)
        System.out.println(A % B);
        
        // Scanner 리소스 해제 (메모리 절약)
        sc.close();
    }
}

/*
 * 학습 가이드:
 * 
 * 1. 변수와 자료형
 *    - int: 정수를 저장하는 자료형 (-2,147,483,648 ~ 2,147,483,647)
 *    - 변수명은 의미 있게 짓는 것이 좋습니다 (A, B보다는 firstNum, secondNum)
 * 
 * 2. 연산자 우선순위
 *    - *, /, % 가 +, - 보다 먼저 계산됩니다
 *    - 같은 우선순위라면 왼쪽부터 계산됩니다
 * 
 * 3. 입출력 기초
 *    - Scanner: 다양한 타입의 입력을 받을 수 있습니다
 *    - System.out.println(): 한 줄씩 출력하며 줄바꿈이 자동으로 됩니다
 * 
 * 4. 주의사항
 *    - 0으로 나누면: ArithmeticException 발생 (이 문제에서는 B가 0이 아님을 보장)
 *    - 나머지 연산에서 음수: Java에서는 피제수의 부호를 따릅니다
 */