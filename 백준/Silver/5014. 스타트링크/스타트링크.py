import sys

input = sys.stdin.readline
from collections import deque


def bfs(x):
    queue = deque([x])

    while queue:
        now = queue.popleft()
        visitied[x] = 1

        for i in d:
            np = now + i

            if 0 < np <= F and visitied[np] == 0:
                queue.append(np)
                visitied[np] = visitied[now] + 1

F, S, G, U, D = map(int, input().split())

visitied = [0] * (F + 1)
d = [U, -D]

bfs(S)

if visitied[G] != 0:
    print(visitied[G]-1)
elif visitied[G] == 0:
    print('use the stairs')