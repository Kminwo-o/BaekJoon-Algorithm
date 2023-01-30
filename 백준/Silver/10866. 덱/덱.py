import sys 
from collections import deque
input = sys.stdin.readline

N = int(input())
dequee = deque()

for i in range(N):
    order = input().split()
    if 'push_front' in order:
        dequee.appendleft(order[1])
    
    elif 'push_back' in order:
        dequee.append(order[1])

    if 'pop_front' in order:
        if dequee:
            print(dequee[0])
            dequee.popleft()
        else:
            print(-1)
    
    if 'pop_back' in order:
        if dequee:
            print(dequee[-1])
            dequee.pop()
        else:
            print(-1)

    if 'size' in order:
        print(len(dequee))
    
    if 'empty' in order:
        if not dequee:
            print(1)
        else:
            print(0)
    
    if 'front' in order:
        if not dequee:
            print(-1)
        else:
            print(dequee[0])
    
    if 'back' in order:
        if not dequee:
            print(-1)
        else:
            print(dequee[-1])