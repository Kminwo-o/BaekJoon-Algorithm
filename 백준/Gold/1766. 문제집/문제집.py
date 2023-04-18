import sys
from heapq import heappop, heappush
input = sys.stdin.readline

# 문제 수 N, 정보 개수 M
N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
inDegree = [0 for _ in range(N+1)]
ans = []

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    inDegree[B] += 1

queue = []

for i in range(1, N+1):
    if not inDegree[i]:
        heappush(queue, i)

while queue:
    problem = heappop(queue)
    ans.append(problem)

    for i in graph[problem]:
        inDegree[i] -= 1
        if not inDegree[i]:
            heappush(queue, i)

print(*ans)