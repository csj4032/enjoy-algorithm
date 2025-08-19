package levelTwo;

import java.util.Arrays;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150369">택배 배달과 수거하기</a>
 * Category : 그리디 알고리즘과 투 포인터
 * Description : "어차피 멀리 갈 바에야 꽉 채워서 가고, 다 비운 상태로 돌아온다"
 */
public class ParcelDelivery {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = n - 1;
        int pickup = n - 1;
        while (delivery >= 0 || pickup >= 0) {
            while (delivery >= 0 && deliveries[delivery] == 0) delivery--;
            while (pickup >= 0 && pickups[pickup] == 0) pickup--;
            if (delivery < 0 && pickup < 0) break;
            int dist = Math.max(delivery, pickup) + 1;
            answer += dist * 2;

            int load = cap;
            for (int i = delivery; i >= 0 && load > 0; i--) {
                int delivered = Math.min(deliveries[i], load);
                load -= delivered;
                deliveries[i] -= delivered;
            }

            load = cap;
            for (int i = pickup; i >= 0 && load > 0; i--) {
                int picked = Math.min(pickups[i], load);
                load -= picked;
                pickups[i] -= picked;
            }
        }
        return answer;
    }
}
