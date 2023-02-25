import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(x):
    visited[x] = 1
    
    for i in V_lst[x]:
        if visited[i] == 1:
            result_lst[x] = i
        else:
            dfs(i)

N = int(input())
V_lst = [[] for _ in range(N+1)]
visited = [0] * (N+1)
result_lst = [0] * (N+1)

for _ in range(N-1):
    a, b = map(int, input().split())

    V_lst[a].append(b)
    V_lst[b].append(a)

dfs(1)

for i in range(2, N+1):
    print(result_lst[i])