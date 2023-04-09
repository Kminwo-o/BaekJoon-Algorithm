import sys
import heapq
input = sys.stdin.readline



def dijkstra(start):
    # 갈 도시 의 수, 최소 비용을 위해 가장 큰 값으로
    heap_q = []
    # 비용과 도시
    heapq.heappush(heap_q, (0, start))
    visited[start] = 0

    # 모든 도시를 방문하면 종료
    while heap_q:
        e, s = heapq.heappop(heap_q)
        
        # 방문 한 곳에 드는 비용이 더 현재가 더 낮으면 스킵
        if visited[s] < e:
            continue
        
        for ns, ne in bus[s]:
            nd = e + ne

            if visited[ns] > nd:
                heapq.heappush(heap_q, (nd, ns))
                visited[ns] = nd

# 도시의 개수
N = int(input().strip())
# 버스의 개수
M = int(input().strip())
# 이차원 배열로 이동 간 금액 찾기
bus = [[] for _ in range(N+1)]
# 방문체크, 도시의 개수가 1000개. set은 시간초과 날거 같음
visited = [1e9] * (N+1)

for _ in range(M):
    a, b, c = map(int, input().split())
    
    bus[a].append((b, c))

start, end = map(int, input().split())

dijkstra(start)

print(visited[end]) 