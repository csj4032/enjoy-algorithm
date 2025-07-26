/**
 * 백준 15552번: 빠른 A+B
 * https://www.acmicpc.net/problem/15552
 * 
 * 문제 설명:
 * 많은 수의 테스트 케이스에 대해 A+B를 계산하는 문제
 * 단순한 Scanner로는 시간 초과가 발생할 수 있어 빠른 입출력이 필요
 * 
 * 핵심 개념:
 * - 빠른 입출력 (BufferedReader, BufferedWriter)
 * - IOException 예외 처리
 * - 문자열 파싱 (split, parseInt)
 * - 배열을 이용한 결과 저장
 * - 버퍼 플러시 (bw.flush())
 * - 대용량 데이터 처리 최적화
 * 
 * 시간복잡도: O(t) - 테스트 케이스 개수에 비례
 * Scanner 대신 BufferedReader/Writer를 사용하여 성능 최적화
 */
package p15552;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// 빠른 출력을 위한 BufferedWriter
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 빠른 입력을 위한 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine().trim());  // 테스트 케이스 개수
		int[] m = new int[t];  // 결과를 저장할 배열

		// 각 테스트 케이스 처리
		for (int i = 0; i < t; i++) {
			String[] line = br.readLine().split(" ");  // 공백으로 분리
			// A + B 계산하여 배열에 저장
			m[i] = Integer.parseInt(line[0]) + Integer.parseInt(line[1]);
		}

		// 결과 출력
		for (int i = 0; i < t; i++) {
			bw.write(m[i] + "\n");
		}

		bw.flush();  // 버퍼에 남은 데이터를 모두 출력
	}
}