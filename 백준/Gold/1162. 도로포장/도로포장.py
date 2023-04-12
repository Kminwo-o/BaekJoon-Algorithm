import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

def dijkstra(start):
    heap_q = []
    pack_cnt = 0
    # 1에서 1까지는 포장을 하던 비포장이던 0.
    dp[start][pack_cnt] = 0
    heapq.heappush(heap_q, (0, start, pack_cnt))

    while heap_q:
        # 소요시간, 도착 지점, 포장 횟수
        v, s, cnt = heapq.heappop(heap_q)

        # 소요시간이 이미 더 적은 루트가 있으면 넘어가기
        if dp[s][cnt] < v:
            continue

        # 소요시간 계산
        for ns, nv in graph[s]:
            nd = v + nv

            # 다음 연결된 도로, [포장 횟수]가 소요시간이 더 적으면 바꿔 주기, 그리고 힙에 넣어서 다음 길 찾기
            if dp[ns][cnt] > nd:
                dp[ns][cnt] = nd
                heapq.heappush(heap_q, (nd, ns, cnt))

            # 아직 포장 할 수 있고, 포장 했을 때 기존 시간이 현재 소요시간 보다 높으면 바꾸기. (!중요, 포장을 하면 소요시간이 0이기에 바로 v)
            if cnt < K and dp[ns][cnt+1] > v:
                dp[ns][cnt+1] = v
                # cnt + 1 (포장횟수 넣어서) 만들어 주기.
                heapq.heappush(heap_q, (v, ns, cnt + 1))

N, M, K = map(int, input().split())
graph = [[] for _ in range(N+1)]
# 냅색, 가능한 포장 개수에 따른 최소값을 구하기 위해
dp = [[INF] * (K+1) for _ in range(N+1)]

for i in range(M):
    a, b, c = map(int, input().split())

    # 양방향 도로입니다.
    graph[a].append((b, c))
    graph[b].append((a, c))

# 1에서 N까지 이므로 1에서 한번 출발해서 다 구하면 됨.
dijkstra(1)
# N번째 도착 시의 시간을 구하는 것이기 때문에, N번째 포장 횟수에 따른 소요시간 중 가장 적은 시간을 출력)
print(min(dp[N]))