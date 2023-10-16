import sys
from collections import deque
input = sys.stdin.readline

# bfs 사용하여 찾기, 일반적인 경우에 DFS가 BFS가 더 좋다고 하여서
def bfs(graph, start, visited = []):
    # list보다 처리 속도가 빠른 deque 사용
    queue = deque([start])
    visited[start] = True

    # queu가 빌 때 까지 돌려주기
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

# 매우 중요, 그래프를 연결된 형태로 idx에 맞게 정리 해줘야한다.
for i in range(pair):
    one, two = map(int, input().split())
    
    com_lst[one].append(two)
    com_lst[two].append(one)

# 1. 자기 자신은 빼줘야하기 때문에 -1로 시작
cnt = -1

# visited 안에 true만큼 cnt 해주기

for i in bfs(com_lst, 1, visited):
    if i == True:
        cnt += 1

print(cnt)