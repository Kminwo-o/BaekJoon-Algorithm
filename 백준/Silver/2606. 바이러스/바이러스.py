import sys
from collections import deque
input = sys.stdin.readline

def bfs(graph, start, visited = []):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

    return visited

C = int(input())
pair = int(input())
com_lst = [[] for i in range(C+1)]
visited = [False] * (C+1)

for i in range(pair):
    one, two = map(int, input().split())
    
    com_lst[one].append(two)
    com_lst[two].append(one)

cnt = -1

for i in bfs(com_lst, 1, visited):
    if i == True:
        cnt += 1
        
print(cnt)