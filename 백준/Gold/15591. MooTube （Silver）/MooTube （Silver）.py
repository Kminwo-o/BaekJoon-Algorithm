import sys
from collections import deque
input = sys.stdin.readline

def bfs(k, v):
    visited = [0] * (N+1)
    visited[v] = 1
    ans = 0
    queue = deque([(v, 1e9)])

    while queue:
        v, r = queue.popleft()
        for next_v, next_r in lst[v]:
            next_r = min(r, next_r)
            if not visited[next_v]:
                if next_r >= k:
                    ans += 1
                    queue.append((next_v, next_r))
                    visited[next_v] = 1

    return ans

N, Q = map(int, input().split())
lst = [[] for _ in range(N+1)]

for _ in range(N-1):
    p, q, r = map(int, input().split())

    lst[p].append((q, r))
    lst[q].append((p, r))

for i in range(Q):
    k, v = map(int, input().split())
    print(bfs(k, v))