from collections import deque
import sys

N, K = map(int, input().split())
yosepus = deque([i for i in range(1, N+1)])

pop_lst = []

while yosepus:
    yosepus.rotate(-(K-1))
    pop_lst.append(yosepus.popleft())

print(str(pop_lst).replace('[', '<').replace(']','>'))