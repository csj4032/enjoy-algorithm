package levelTwo;

import java.util.Arrays;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/150369">택배 배달과 수거하기</a>
 * Category : 그리디 알고리즘과 투 포인터
 * Description :가장 먼 집부터 시작해, 현재 트럭 용량으로 배달할 수 있는지 확인합니다.
 * 배달량이 트럭 용량보다 작으면 그대로 배달하고, 남은 용량은 다음 집으로 이어서 사용합니다.
 * 배달량이 트럭 용량보다 많으면, 부족한 만큼 추가 왕복을 계산합니다.
 * 수거도 같은 방식으로 처리하며, 각 집마다 필요한 왕복을 누적합니다.
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
            int maxDistance = Math.max(delivery, pickup) + 1;
            answer += maxDistance * 2L;

            int load = cap;
            for (int i = delivery; i >= 0 && load > 0; i--) {
                if (deliveries[i] > 0) {
                    int delivered = Math.min(deliveries[i], load);
                    deliveries[i] -= delivered;
                    load -= delivered;
                }
            }

            load = cap;
            for (int i = pickup; i >= 0 && load > 0; i--) {
                if (pickups[i] > 0)  {
                    int picked = Math.min(pickups[i], load);
                    pickups[i] -= picked;
                    load -= picked;
                }
            }
        }
        return answer;
    }
}