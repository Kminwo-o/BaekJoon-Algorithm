from collections import deque
import sys

input = sys.stdin.readline

# bfs
def graph(n):
    queue = deque([n])
    cnt = 0
    visited = [0] * (N+1)
    visited[n] = 1
    while queue:
        q = queue.popleft()
        cnt += 1
        
        for i in comArr[q]:
            if not visited[i]:
                queue.append(i)
                visited[i] = 1
    return cnt

N, M = map(int, input().split())
comArr = [[] for _ in range(N+1)]

for _ in range(M):
    A, B = map(int, input().split())
    comArr[B].append(A)

answer = [0 for _ in range(N+1)]
for i in range(1, N+1):
    answer[i] = graph(i)

for i in range(1, N+1):
    if answer[i] == max(answer):
        print(i, end=' ')