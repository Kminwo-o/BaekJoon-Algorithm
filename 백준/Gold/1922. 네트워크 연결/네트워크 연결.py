import sys
import heapq
input = sys.stdin.readline

def Prim(start):
    weight = 0
    heap_q = []
    # 비용, 도시
    heapq.heappush(heap_q, (0, 1))
    while heap_q:
        v, e  = heapq.heappop(heap_q)

        if visited[e] == 1:
            continue
        visited[e] = 1
        weight += v

        for i in graph[e]:
            if 1e9 == visited[i[0]]:
                heapq.heappush(heap_q, (i[1], i[0]))

    return weight


N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
visited = [1e9] * (N+1)

for _ in range(M):
    a, b, c = map(int, input().split())

    graph[a].append((b, c))
    graph[b].append((a, c))

print(Prim(0))