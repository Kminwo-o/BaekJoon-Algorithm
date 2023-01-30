import sys 
from collections import deque

N,M = map(int,input().split())
pop_list = list(map(int, input().split()))
dequue = deque([i for i in range(1, N+1)])

cnt = 0

for i in pop_list:
    if i == dequue[0]:
        dequue.popleft()
        continue

    deque_idx = dequue.index(i)

    if deque_idx > len(dequue) // 2:
        dequue.rotate(len(dequue) - deque_idx)
        cnt += (len(dequue) - deque_idx)

    elif deque_idx <= len(dequue) // 2:
        dequue.rotate(-deque_idx)
        cnt += deque_idx
    dequue.popleft()

print(cnt)