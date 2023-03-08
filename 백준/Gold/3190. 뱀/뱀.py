# 0,0 에서 처음에는 오른쪽을 향한다. L 왼쪽, O 오른쪽

import sys
input = sys.stdin.readline
from collections import deque

def baam(x, y, idx):
    global second
    queue = deque([(x, y)])
    arr[x][y] = 2

    while True:
        second += 1
        x = x + d[idx][0]
        y = y + d[idx][1]

        if 0 <= x < N and 0 <= y < N:
            if arr[x][y] == 1:
                arr[x][y] = 2
                queue.append((x, y))
                
                for i in move:
                    if i[0] == second:
                        if i[1] == 'L':
                            idx = (idx - 1) % 4
                            break
                        else:
                            idx = (idx + 1) % 4
                            break

            elif arr[x][y] == 0:
                arr[x][y] = 2
                queue.append((x,y))
                tail_x, tail_y = queue.popleft()
                arr[tail_x][tail_y] = 0

                for i in move:
                    if i[0] == second:
                        if i[1] == 'L':
                            idx = (idx - 1) % 4
                            break
                        else:
                            idx = (idx + 1) % 4
                            break
            else: break
        else: break              

d = [(0,1), (1,0), (0,-1), (-1,0)] # 우 하 좌 상
    
N = int(input())
K = int(input())

arr = [[0] * N for _ in range(N)]

for _ in range(K):
    x, y = map(int, input().split())
    arr[x-1][y-1] = 1

L = int(input())

move = []
second = 0
idx = 3

for _ in range(L):
    sec, drec = input().split()
    move.append([int(sec), drec])

baam(0,0,0)

print(second)