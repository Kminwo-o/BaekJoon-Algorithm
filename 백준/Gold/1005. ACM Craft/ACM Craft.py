import sys
from collections import deque
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N, K = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    time = [0] +  list(map(int, input().split()))
    # 위상 정렬, 진입차수 개념이 중요.
    inDegree = [0 for _ in range(N+1)]
    dp = [0 for _ in range(N+1)]

    for _ in range(K):
        a, b = map(int, input().split())
        graph[a].append(b)
        # 경로가 생길 때마다 +1
        inDegree[b] += 1

    W = int(input())
    queue = deque()

    for i in range(1, N+1):
        if inDegree[i] == 0:
            queue.append(i)
            # 처음 만들어 질 수 있는 시간은 첫  time idx
            dp[i] = time[i]
    
    while queue:
        build = queue.popleft()
        for i in graph[build]:
            inDegree[i] -= 1
            dp[i] = max(dp[i], dp[build] + time[i])
            if inDegree[i] == 0:
                queue.append(i)
    
    print(dp[W])