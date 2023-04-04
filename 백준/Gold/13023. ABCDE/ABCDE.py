import sys
input = sys.stdin.readline

def dfs(idx, cnt):
    global ans
    if cnt == 4:
        ans = 1
        return

    for i in human_lst[idx]:
        if not visited[i]:
            visited[i] = 1
            dfs(i, cnt + 1)
            if ans == 1:
                return
            visited[i] = 0

N, M = map(int, input().split())
human_lst = [[] for _ in range(N)]
visited = [0] * (N+1)
ans = 0

for i in range(M):
    a, b = map(int, input().split())

    human_lst[a].append(b)
    human_lst[b].append(a)

for i in range(N):
    visited[i] = 1
    dfs(i, 0)
    if ans == 1:
        break
    visited[i] = 0

print(ans)