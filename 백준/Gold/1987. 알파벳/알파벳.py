import sys
from collections import deque

input = sys.stdin.readline

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(r, c, llst):
    global max_
    if lst[r][c] not in llst:
        llst.add(lst[r][c])

    for dr, dc in d:
        nr = r + dr
        nc = c + dc

        if 0 <= nr < R and 0 <= nc < C and lst[nr][nc] not in llst:
            llst.add(lst[nr][nc])
            max_ = max(max_, len(llst))
            dfs(nr, nc, llst)
            llst.remove(lst[nr][nc])

R, C = map(int, input().split())
lst = [list(input().strip()) for _ in range(R)]
max_ = 1
llst = set()
dfs(0, 0, llst)
print(max_)