import sys
input = sys.stdin.readline

N = int(input())
stack = []

for i in range(N):
    order = input().split()
    if 'push' in order:
        stack.append(order[1])
    
    if 'top' in order:
        if 0 < len(stack):
            print(stack[-1])
        else: 
            print(-1)

    if 'size' in order:
        print(len(stack))
    
    if 'empty' in order:
        if 0 == len(stack):
            print(1)
        else:
            print(0)
    
    if 'pop' in order:
        if 0 == len(stack):
            print(-1)
        else:
            print(stack.pop(-1))