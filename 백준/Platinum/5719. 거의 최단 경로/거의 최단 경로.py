import sys
from heapq import heappop, heappush
from collections import deque
input = sys.stdin.readline

def dijkstra(start):
    heap_q = []
    weight[start] = 0
    heappush(heap_q, (0, start))

    while heap_q:
        val, s = heappop(heap_q)
        if weight[s] < val:
            continue

        for p, v in graph[s]:
            if road_visited[s][v]:
                continue
            nv = weight[s] + p
            if weight[v] > nv:
                weight[v] = nv
                heappush(heap_q, (nv, v))

def bfs(start):
    queue = deque([start])
    road_visited[start][start] = 1
    while queue:
        start = queue.popleft()
        if start == S:
            continue

        for p, s in graph_reverse[start]:
            if weight[start] == weight[s] + p and not road_visited[s][start]:
                queue.append(s)
                road_visited[s][start] = 1

while True:
    N, M = map(int, input().split())
    if N == 0 and M == 0: break
    S, D = map(int, input().split())

    graph = [[] for _ in range(N)]
    graph_reverse = [[] for _ in range(N)]
    road_visited = [[0] * N for _ in range(N)]

    for _ in range(M):
        U, V, P = map(int, input().split())
        graph[U].append((P, V))
        graph_reverse[V].append((P, U))

    weight = [1e9] * N
    dijkstra(S)
    bfs(D)
    weight = [1e9] * N
    dijkstra(S)

    if weight[D] == 1e9:
        print(-1)
    else:
        print(weight[D])