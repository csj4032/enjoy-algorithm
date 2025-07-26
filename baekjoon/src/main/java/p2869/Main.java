package p2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제목: 달팡이는 올라가고 싶다
 * 링크: https://www.acmicpc.net/problem/2869
 * 분류: 수학, 그리디
 * 
 * 핵심 아이디어:
 * - 달팡이가 높이 V인 나무 막대를 올라가는 문제
 * - 낮에 A미터 올라가고, 밤에 B미터 미끄러짐
 * - 맨 마지막 날에는 미끄러지지 않음 (정상에 도달하면 끝)
 * 
 * 알고리즘 접근:
 * 1. 마지막 날을 제외한 나머지 날들: 하루에 순 상승 (A-B)미터
 * 2. 마지막 날: A미터만 올라가면 되므로 (V-A)미터까지만 필요
 * 3. 따라서 전체 일수 = ceil((V-A) / (A-B)) + 1
 * 
 * 학습 개념:
 * - 수학적 모델링과 공식 도출
 * - 올림 연산(Ceiling)의 활용
 * - 단순 시뮬레이션 대신 수학적 해결
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());  // 낮에 올라가는 거리
        int B = Integer.parseInt(st.nextToken());  // 밤에 미끄러지는 거리
        int Z = Integer.parseInt(st.nextToken());  // 나무 막대의 높이
        
        // 마지막 날을 제외한 나머지 날들에 대한 계산
        // (Z-A)미터까지 도달하는데 필요한 날수: ceil((Z-A) / (A-B))
        // 마지막 날 1일 추가
        System.out.println((int) Math.ceil((double) (Z - A) / (A - B)) + 1);
    }
}
