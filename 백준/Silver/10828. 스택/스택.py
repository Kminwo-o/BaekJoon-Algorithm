import sys
input = sys.stdin.readline

N = int(input())
stack = []

for i in range(N):
    order = input().split()
    if 'push' in order:
        stack.append(int(order[1]))
    
    if 'top' in order  and 0 < len(stack):
        print(stack[-1])

    elif 'top' in order and 0 == len(stack):
        print(-1)

    if 'size' in order:
        print(len(stack))
    
    if 'empty' in order and 0 == len(stack):
        print(1)
    
    elif 'empty' in order:
        print(0)
    
    if 'pop' in order and 0 == len(stack):
        print(-1)
    
    elif 'pop' in order:
        print(stack.pop(-1))
