package p14502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 제목 : 연구소
 * 링크 : https://www.acmicpc.net/problem/14502
 * 분류 : 구현, 그래프 탐색, 브루트포스, BFS, 시뮬레이션
 * 
 * === 문제 해설 ===
 * NxM 크기의 연구소에서 바이러스가 퍼지는 것을 막기 위해 벽 3개를 설치하여
 * 안전 영역의 크기를 최대화하는 문제입니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) 조합론적 접근:
 *    - 빈 공간 중에서 3개를 선택하는 조합 문제: C(빈공간수, 3)
 *    - 최악의 경우: 8×8 격자에서 C(64, 3) ≈ 41,000 경우의 수
 * 
 * 2) 그래프 탐색 이론:
 *    - BFS를 이용한 바이러스 확산 시뮬레이션
 *    - 연결된 컴포넌트(Connected Component) 탐색
 *    - 4방향 인접 노드에 대한 확산 모델링
 * 
 * 3) 최적화 문제:
 *    - 제약 조건: 정확히 3개의 벽 설치
 *    - 목적 함수: 안전 영역 크기 최대화
 *    - 완전 탐색으로 전역 최적해 보장
 * 
 * === 알고리즘 설계 ===
 * 1) 2단계 접근법:
 *    - 1단계: 벽 3개 설치의 모든 경우의 수 생성 (브루트포스)
 *    - 2단계: 각 경우에 대해 바이러스 확산 시뮬레이션 (BFS)
 * 
 * 2) 백트래킹을 이용한 조합 생성:
 *    - DFS로 깊이 3까지 탐색
 *    - 방문 체크 배열로 중복 방지
 *    - 상태 복원으로 다른 경우의 수 탐색
 * 
 * === 구현 세부사항 ===
 * 1) 자료구조 선택:
 *    - int[][] l: 연구소 지도 (0:빈공간, 1:벽, 2:바이러스)
 *    - boolean[][] v: 벽 설치 시 방문 체크
 *    - Queue<Point>: BFS를 위한 바이러스 위치 저장
 *    - int[][] r: 4방향 이동을 위한 방향 벡터
 * 
 * 2) 바이러스 확산 시뮬레이션:
 *    - 초기 바이러스 위치들을 큐에 저장
 *    - BFS로 4방향 확산 (상하좌우)
 *    - 경계 체크 및 벽/이미 감염된 곳 제외
 * 
 * 3) 안전 영역 계산:
 *    - 전체 영역에서 벽과 바이러스 영역 제외
 *    - 매번 격자 전체를 스캔하여 계산
 * 
 * === 최적화 기법 ===
 * 1) 메모리 최적화:
 *    - 배열 복사 대신 상태 백트래킹 사용
 *    - Queue 재사용으로 객체 생성 비용 절약
 * 
 * 2) 시간 복잡도 최적화:
 *    - 초기 바이러스 위치 미리 저장
 *    - 불필요한 경계 체크 최소화 
 *    - 조기 종료 조건 설정 가능
 * 
 * 3) 공간 활용 최적화:
 *    - 1차원 인덱싱으로 메모리 접근 패턴 개선
 *    - 비트마스크를 이용한 상태 압축 가능
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O(C(빈공간수, 3) × N × M)
 *   - 조합 생성: C(최대64, 3) ≈ 41,000
 *   - 각 조합당 BFS: O(N × M)
 *   - 전체: O(41,000 × 64) ≈ 2.6M 연산
 * 
 * - 공간복잡도: O(N × M)
 *   - 격자 저장: O(N × M)
 *   - BFS 큐: O(N × M) 최악의 경우
 *   - 방문 체크 배열: O(N × M)
 * 
 * === 대안 해결법 ===
 * 1) 비트마스킹 최적화:
 *    - 격자 상태를 비트로 압축
 *    - 빠른 상태 복사 및 비교
 * 
 * 2) 휴리스틱 가지치기:
 *    - 현재까지의 최댓값으로 조기 종료
 *    - 바이러스와 가까운 곳 우선 벽 설치
 * 
 * 3) 병렬 처리:
 *    - 독립적인 조합들을 병렬로 처리
 *    - 멀티스레딩으로 성능 향상
 * 
 * 4) 동적 계획법 접근:
 *    - 특정 패턴에서 메모이제이션 활용
 *    - 하지만 상태 공간이 복잡해 비실용적
 * 
 * === 시뮬레이션 문제의 특징 ===
 * 1) 상태 변화 모델링:
 *    - 현실 상황을 추상화하여 알고리즘으로 구현
 *    - 시간에 따른 상태 변화 시뮬레이션
 * 
 * 2) 완전 탐색의 필요성:
 *    - 최적해 보장을 위한 모든 경우의 수 확인
 *    - 탐욕적 접근으로는 최적해 보장 어려움
 * 
 * 3) 실제 응용 분야:
 *    - 전염병 확산 모델링
 *    - 네트워크 보안 (방화벽 배치)
 *    - 재해 대응 계획 수립
 *    - 게임 AI에서의 상황 예측
 */
public class Main {

	static int n;
	static int m;
	static int max;
	static int wc = 3;
	static int[][] l;
	static int[][] r = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static boolean[][] v;
	static Queue<Point> queue = new LinkedList();

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		l = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				var k = sc.nextInt();
				l[i][j] = k;
				if (k == 2) queue.offer(new Point(i, j));
			}
		}
		dsf(0);
		System.out.println(max);
	}

	private static void dsf(int d) {
		if (d == wc) {
			max = Math.max(max, getMax());
			return;
		}

		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (l[j][k] == 0 && !v[j][k]) {
					v[j][k] = true;
					l[j][k] = 1;
					dsf(d + 1);
					l[j][k] = 0;
					v[j][k] = false;
				}
			}
		}
	}

	private static int getMax() {
		var q = new LinkedList<>(queue);
		var ll = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ll[i][j] = l[i][j];
			}
		}
		while (!q.isEmpty()) {
			var t = q.poll();
			for (int i = 0; i < 4; i++) {
				var y = t.y + r[i][0];
				var x = t.x + r[i][1];
				if (0 <= y && y < n && 0 <= x && x < m) {
					if (ll[y][x] == 0) {
						q.offer(new Point(y, x));
						ll[y][x] = 2;
					}
				}
			}
		}
		var k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ll[i][j] == 0) k++;
			}
		}
		return k;
	}
}

class Point {
	Integer y;
	Integer x;

	Point(Integer y, Integer x) {
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "Point{" + "y=" + y + ", x=" + x + '}';
	}
}
