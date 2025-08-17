package levelTwo;

import java.util.Arrays;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150369">택배 배달과 수거하기</a>
 * Category : 그리디 알고리즘과 투 포인터
 * Description : 택배를 배달하고 수거하는 문제로, 주어진 용량(cap)과 각 위치의 배달 및 수거량을 고려하여 최소 이동 거리를 계산하는 문제입니다.
 */
public class ParcelDelivery {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = n - 1;
        int p = n - 1;

        while (d >= 0 || p >= 0) {
            while (d >= 0 && deliveries[d] == 0) d--;
            while (p >= 0 && pickups[p] == 0) p--;

            if (d < 0 && p < 0) break;
            int distance = Math.max(d, p) + 1;
            answer += distance * 2L;

            int load = cap;
            for (int i = d; i >= 0 && load > 0; i--) {
                if (deliveries[i] > 0) {
                    int delivered = Math.min(deliveries[i], load);
                    deliveries[i] -= delivered;
                    load -= delivered;
                }
            }

            load = cap;
            for (int i = p; i >= 0 && load > 0; i--) {
                if (pickups[i] > 0) {
                    int picked = Math.min(pickups[i], load);
                    pickups[i] -= picked;
                    load -= picked;
                }
            }
        }

        return answer;
    }
}
