import sys
from collections import deque
input = sys.stdin.readline

def check(visit):
    for i in range(1, N+1):
        if not visit[i]:
            return True
    return False

# 문제 수 N, 정보 개수 M
N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
inDegree = [0 for _ in range(N+1)]
ans = []
visited = [0] * (N+1)

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    inDegree[B] += 1

queue = deque()

while check(visited):
    for i in range(1, N+1):
        if inDegree[i] == 0 and not visited[i]:
            visited[i] = 1
            queue.append(i)
            ans.append(i)
            break

    while queue:
        problem = queue.popleft()
        for i in graph[problem]:
            inDegree[i] -= 1

print(*ans)