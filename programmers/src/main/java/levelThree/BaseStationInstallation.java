package levelThree;

/**
 * Link : https://programmers.co.kr/learn/courses/30/lessons/12979
 * Category : simulation
 * Idea : 기지국 start < left bound 크면 기지국 설치 위치가 존재, 그리고 기지국 설치 위치를 모두 탐색 후 start 의 위치가 n 보다 작거나 같으면 아직 기지국 설치 위치가 존재
 */
public class BaseStationInstallation {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int[][] maps = new int[stations.length + 1][2];
        for (int i = 0; i <= stations.length; i++) {
            maps[i][0] = 1;
            maps[i][1] = n;
        }
        for (int i = 0; i < stations.length; i++) {
            maps[i][1] = stations[i] - w - 1;
            maps[i + 1][0] = stations[i] + w + 1;
        }
        for (int[] map : maps) {
            if (map[0] > map[1]) continue;
            int length = map[1] - map[0] + 1;
            int count = length / (2 * w + 1) + (length % (2 * w + 1) == 0 ? 0 : 1);
            answer += count;
        }
        return answer;
    }

    public int solution2(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int start = 1;

        for (int station : stations) {
            int leftBoundary = station - w;
            if (start < leftBoundary) {
                int gap = leftBoundary - start;
                answer += (gap + coverage - 1) / coverage;
            }
            start = station + w + 1;
        }

        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + coverage - 1) / coverage;
        }

        return answer;
    }
}
