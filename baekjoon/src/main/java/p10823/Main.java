package p10823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 제목: 더하기 2
 * 링크: https://www.acmicpc.net/problem/10823
 * 분류: 문자열, 파싱, 큰 수 연산
 * 
 * 핵심 아이디어:
 * - 여러 줄에 걸쳐 콤마로 구분된 큰 정수들의 합을 구하는 문제
 * - BigInteger를 사용하여 큰 수의 연산 처리
 * 
 * 알고리즘 접근:
 * 1. 여러 줄의 입력을 모두 읽어서 하나의 문자열로 결합
 * 2. 콤마를 구분자로 사용하여 토큰으로 분할
 * 3. BigInteger를 사용하여 큰 수들의 합계 계산
 * 
 * 학습 개념:
 * - 여러 줄 입력 처리 (EOF까지)
 * - BigInteger를 이용한 큰 수 연산
 * - StringTokenizer를 이용한 토큰 분할
 * - BufferedReader를 이용한 효율적 입력 처리
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// 다른 방법 1: Scanner와 Stream을 이용한 방법 (주석 처리)
//		Scanner sc = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();
//		while (sc.hasNextLine()) {
//			String line = sc.nextLine();
//			sb.append(line);
//			if (line.length() == 0) break;
//		}
//		Integer sum = Arrays.stream(sb.toString().split(",")).mapToInt(Integer::new).sum();
//		System.out.println(sum);

		// 현재 구현: BufferedReader와 BigInteger 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		BigInteger result = new BigInteger("0");  // 합계 초기값

		String str;
		StringBuffer sb = new StringBuffer();
		
		// 모든 입력 줄을 하나의 문자열로 결합
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}

		// 콤마를 구분자로 하는 토크나이저 생성
		token = new StringTokenizer(sb.toString());
		
		// 각 토큰을 BigInteger로 변환하여 합계에 더함
		while (token.hasMoreTokens()) {
			result = result.add(new BigInteger(token.nextToken(",")));
		}
		
		System.out.println(result);  // 최종 합계 출력
	}
}