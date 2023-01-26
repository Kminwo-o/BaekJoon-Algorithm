import sys
input = sys.stdin.readline

N = int(input())
queue = list()

for i in range(N):
    order = input().split()
    if 'push' in order:
        queue.append(order[1])
    
    if 'front' in order:
        if 0 < len(queue):
            print(queue[0])
        else: 
            print(-1)
    
    if 'back' in order:
        if 0 < len(queue):
            print(queue[-1])
        else:
            print(-1)

    if 'size' in order:
        print(len(queue))
    
    if 'empty' in order:
        if 0 == len(queue):
            print(1)
        else:
            print(0)
    
    if 'pop' in order:
        if 0 == len(queue):
            print(-1)
        else:
            print(queue.pop(0))