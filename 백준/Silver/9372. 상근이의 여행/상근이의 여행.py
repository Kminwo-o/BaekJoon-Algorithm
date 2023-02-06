import sys
from collections import deque
input = sys.stdin.readline

# dfs
def dfs(v):
    visited[v] = True

    for i in graph[v]:
        if not visited[i]:
            dfs(i)

    return visited

T = int(input())

for _ in range(T):
    N,M = map(int,input().split())

    visited = [False] * (N+1)
    graph = [[] for i in range(N+1)]
    
    for i in range(1,M+1):
        a, b = map(int, input().split())
    
        graph[a].append(b)
        graph[b].append(a)

    for i in graph:
        i.sort()
    
    cnt = -1
    for i in dfs(1):
        if i == True:
            cnt += 1
    
    print(cnt)