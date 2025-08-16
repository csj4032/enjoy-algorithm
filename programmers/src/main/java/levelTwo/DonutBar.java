package levelTwo;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/258711">...</a>
 * Category: Level 2
 * 생성된 정점 (The Generated Node) 찾기 : 생성된 정점은 모든 이야기의 시작점. 이 정점은 다른 어떤 정점으로부터도 간선을 받지 않으면서(진입 차수 = 0), 여러 개의 개별 그래프로 간선을 내보내는(진출 차수 ≥ 2) 유일한 "허브(Hub)" 역할
 * 막대 모양 그래프 (Bar Graphs) 개수 세기 : 막대 모양 그래프는 한쪽 방향으로만 이어지는 길과 같음. 따라서 길의 끝에는 더 이상 나아갈 곳이 없는 "막다른 길(Dead-end)" 정점이 반드시 하나 존재합니다. 이 정점은 간선을 받기만 하고 밖으로 내보내는 간선이 전혀 없음(진출 차수 = 0)
 * 8자 모양 그래프 (8-Figure Graphs) 개수 세기 : 8자 모양 그래프는 두 개의 도넛 모양 고리가 하나의 정점에서 만나는 형태. 이 "교차점(Junction)" 정점은 두 개의 고리로부터 각각 간선을 받고(진입 차수 ≥ 2), 다시 두 개의 고리로 각각 간선을 내보내는(진출 차수 ≥ 2) 유일한 특징
 * 도넛 모양 그래프 (Donut Graphs) 개수 추론하기 : 도넛 모양 그래프는 모든 정점이 하나의 간선을 받고 하나의 간선을 내보내는(진입/진출 차수 = 1) 완벽한 순환 구조. 따라서 특별한 "지문"을 가진 정점이 없어 직접 세기가 까다로움
 */
public class DonutBar {

    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodeInfo = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            nodeInfo.putIfAbsent(from, new int[2]);
            nodeInfo.get(from)[1]++;
            nodeInfo.putIfAbsent(to, new int[2]);
            nodeInfo.get(to)[0]++;
        }
        for (Map.Entry<Integer, int[]> entry : nodeInfo.entrySet()) {
            System.out.println(entry.getKey() + " -> in: " + entry.getValue()[0] + ", out: " + entry.getValue()[1]);
        }
        int[] answer = new int[4];

        for (Map.Entry<Integer, int[]> entry : nodeInfo.entrySet()) {
            int node = entry.getKey();
            int inDegree = entry.getValue()[0];
            int outDegree = entry.getValue()[1];
            if (inDegree == 0 && outDegree >= 2) {
                answer[0] = node;
            } else if (outDegree == 0) {
                answer[2]++;
            } else if (inDegree >= 2 && outDegree >= 2) {
                answer[3]++;
            }
        }

        answer[1] = nodeInfo.get(answer[0])[1] - (answer[2] + answer[3]);
        return answer;
    }
}