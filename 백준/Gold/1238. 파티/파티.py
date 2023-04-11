import sys
import heapq
input = sys.stdin.readline

def dijkstra(start):
    heap_q = []
    visited = [1e9] * (N+1)
    visited[start] = 0
    heapq.heappush(heap_q, (0, start))

    while heap_q:
        e, s = heapq.heappop(heap_q)

        if visited[s] < e:
            continue

        for ns, ne in graph[s]:
            nd = e + ne

            if visited[ns] > nd:
                heapq.heappush(heap_q, (nd, ns))
                visited[ns] = nd
    
    return visited

# N = 총 학생, M = 길의 갯수, X = 모이려는 마을
N, M, X = map(int, input().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    # 단방향 입니다.
    graph[a].append((b, c))

ans = 0
for i in range(1, N+1):
    # 갔다
    party_attend = dijkstra(i)
    # 왔다
    home_comming = dijkstra(X)
    ans = max(ans, party_attend[X] + home_comming[i])

print(ans)