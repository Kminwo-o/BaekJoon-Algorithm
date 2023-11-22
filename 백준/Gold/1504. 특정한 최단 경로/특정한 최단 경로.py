import heapq
import sys
input = sys.stdin.readline

def dijkstra(start):
    distance = [1e9] * (n +1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]

            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return distance

n, e = map(int, input().split())

graph = [[] for _ in range (n+1)]

for i in range(e):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

v1, v2 = map(int, input().split())

first_start = dijkstra(1)
v1_start = dijkstra(v1)
v2_start = dijkstra(v2)

# 최초에서 v1까지 - v1에서 v2까지 - v2에서 end 까지 거리
v1_f = first_start[v1] + v1_start[v2] + v2_start[n]
# 최초에서 v2까지 - v2에서 v1까지 - v1에서 end 까지 거리
v2_f = first_start[v2] + v2_start[v1] + v1_start[n]

ans = min(v1_f, v2_f)

if ans >= 1e9:
    ans = -1

print(ans)