import sys
import heapq

input = sys.stdin.readline

def Prim():
    mst = set()
    weight = 0
    heap_q = []
    heapq.heappush(heap_q, (0, 1))
    while heap_q:
        cur = heapq.heappop(heap_q)

        if cur[1] in mst:
            continue

        mst.add(cur[1])
        weight += cur[0]

        for i in graph[cur[1]]:
            if i not in mst:
                heapq.heappush(heap_q, (i[1], i[0]))

    return weight


V, E = map(int, input().split())
graph = [[] for _ in range(V + 1)]

for _ in range(E):
    a, b, c = map(int, input().split())

    graph[a].append((b, c))
    graph[b].append((a, c))

print((Prim()))