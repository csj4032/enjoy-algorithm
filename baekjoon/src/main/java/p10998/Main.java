package p10998;

import java.util.Scanner;

/**
 * 백준 10998번 - A×B  
 * https://www.acmicpc.net/problem/10998
 * 
 * 난이도: Bronze V
 * 분류: 수학, 구현, 사칙연산
 * 
 * 프로그래밍 기초 개념:
 * 1. 기본 입출력 (Scanner 사용법)
 * 2. 정수 자료형 (int) 
 * 3. 곱셈 연산자 (*)
 * 4. 변수 선언과 초기화
 * 
 * 문제 이해:
 * - 두 정수 A와 B를 입력받아 A×B를 출력하는 문제
 * - 가장 기본적인 곱셈 연산 문제
 * 
 * 초보자를 위한 팁:
 * - 이 문제는 프로그래밍의 가장 기본기를 연습하는 문제입니다
 * - Scanner 사용법과 기본 연산을 익혀보세요
 * - 입력 → 연산 → 출력의 기본 흐름을 이해해보세요
 */
public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성 - 콘솔 입력을 받기 위해
        Scanner sc = new Scanner(System.in);
        
        // 두 정수 A, B를 입력받습니다
        int A = sc.nextInt(); // 첫 번째 정수 입력
        int B = sc.nextInt(); // 두 번째 정수 입력
        
        // A와 B의 곱을 계산하고 출력합니다
        System.out.println(A * B);
        
        // Scanner 리소스 해제
        sc.close();
    }
}

/*
 * 학습 가이드:
 * 
 * 1. 프로그램의 기본 구조
 *    - 입력 (Input): Scanner로 데이터 받기
 *    - 처리 (Process): 연산 수행  
 *    - 출력 (Output): 결과 출력
 * 
 * 2. Scanner 클래스 사용법
 *    - Scanner sc = new Scanner(System.in); // 객체 생성
 *    - sc.nextInt(); // 정수 입력 받기
 *    - sc.nextDouble(); // 실수 입력 받기  
 *    - sc.next(); // 문자열 입력 받기
 *    - sc.close(); // 리소스 해제
 * 
 * 3. 자바의 기본 자료형
 *    - int: 정수 (-2,147,483,648 ~ 2,147,483,647)
 *    - long: 더 큰 정수 범위가 필요할 때
 *    - double: 실수 (소수점 포함)
 *    - boolean: true/false 값
 *    - char: 단일 문자
 * 
 * 4. 연산자의 종류
 *    - 산술 연산자: +, -, *, /, %
 *    - 비교 연산자: ==, !=, <, >, <=, >=
 *    - 논리 연산자: &&, ||, !
 *    - 대입 연산자: =, +=, -=, *=, /=
 * 
 * 5. 실습해보기
 *    - 다른 사칙연산(+, -, /)도 해보세요
 *    - 큰 수의 곱셈도 테스트해보세요
 *    - 음수의 곱셈 결과도 확인해보세요
 * 
 * 6. 주의사항
 *    - 곱셈 결과가 int 범위를 초과할 수 있습니다
 *    - 필요시 long 자료형을 사용하세요
 *    - 예: int의 최댓값은 약 21억입니다
 * 
 * 7. 확장 학습
 *    - 세 개 이상의 수 곱셈
 *    - 여러 줄에 걸친 입력 처리
 *    - 결과값의 자릿수 계산
 */