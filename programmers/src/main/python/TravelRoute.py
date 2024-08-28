# 분기 되는 여행 경로에 따라 방문 공항 체크 및 경로 저장

from collections import deque
from collections import defaultdict


def solution(tickets):
    graph = defaultdict(list)
    for key, value in tickets:
        graph[key].append(value)

    for node in graph:
        graph[node].sort()

    def dfs():
        stack = ["ICN"]
        path = []
        while len(stack) > 0:
            airport = stack[-1]
            if airport not in graph or len(graph[airport]) == 0:
                path.append(stack.pop())
            else:
                stack.append(graph[airport].pop(0))
        return path[::-1]

    answer = dfs()
    return answer


# solution([["ICN", "AAD"], ["ICN", "JFK"], ["JFK", "ICN"]])
# solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]])
solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]])
