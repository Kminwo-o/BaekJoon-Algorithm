import sys
import copy

input = sys.stdin.readline


def dfs(depth, graph):
    global 가장적은사각지대
    if depth == cctv_len:
        ans = 0
        for i in range(N):
            for j in range(M):
                if graph[i][j] == 0:
                    ans += 1
        가장적은사각지대 = min(ans, 가장적은사각지대)
        return

    tmp_graph = copy.deepcopy(graph)
    dir, x, y = cctv_lst[depth]
    for i in direc[dir]:
        monitor(tmp_graph, i, x, y)
        dfs(depth + 1, tmp_graph)
        tmp_graph = copy.deepcopy(graph)


def monitor(graph, dir, x, y):
    for i in dir:
        nx = x
        ny = y
        while True:
            nx += d[i][0]
            ny += d[i][1]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                break
            elif graph[nx][ny] == 6:
                break
            else:
                graph[nx][ny] = 7

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
direc = [
    [],
    [[0], [1], [2], [3]],
    [[0, 1], [2, 3]],
    [[0, 3], [3, 1], [1, 2], [2, 0]],
    [[0, 2, 3], [3, 0, 1], [1, 2, 3], [2, 0, 1]],
    [[0, 1, 2, 3]]
]

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

cctv_lst = []
for i in range(N):
    for j in range(M):
        if 1 <= arr[i][j] <= 5:
            cctv_lst.append((arr[i][j], i, j))

cctv_len = len(cctv_lst)

가장적은사각지대 = 1e9
dfs(0, arr)
print(가장적은사각지대)