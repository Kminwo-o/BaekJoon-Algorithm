import sys
from collections import deque
input = sys.stdin.readline

# bfs
def bfs(graph, start, visited = []):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        print(v,end=' ')
        # graph = [[], [2, 3, 4], [1, 4], [1, 4], [1, 2, 3]]
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
# dfs
def dfs(graph, start, visited = []):
    visited[start] = True
    
    print(start, end=' ')
    # graph = [[], [2, 3, 4], [1, 4], [1, 4], [1, 2, 3]]
    for i in graph[start]:
        if not visited[i]:
            dfs(graph, i, visited)

N, M, V = map(int, input().split())
graph = [[] for i in range(N+1)]
visited1 = [False] * (N+1)
visited2 = [False] * (N+1)

for i in range(M):
    one, two = map(int, input().split())

    graph[one].append(two)
    graph[two].append(one)

# 왜,,, why...? ... 하...
for i in graph:
    i.sort()
    
dfs(graph,V, visited1)
print()
bfs(graph,V, visited2)