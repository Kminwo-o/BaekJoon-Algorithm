import sys
input = sys.stdin.readline

N = int(input())
num_list = []

for _ in range(N):
    num_list.append(int(input()))

stack = []
idx = 0
sign_list = []

for i in range(1,N+1):
    if not stack:
        stack.append(i)
        sign_list.append('+')
        continue

    while True:
        if stack[idx] == num_list[0]:
            num_list.pop(0)
            stack.pop()
            sign_list.append('-')
            idx -= 1
            if not stack:
                break
        else:
            break
    if not stack or stack[idx] != num_list[0]:
        stack.append(i)
        sign_list.append('+')
        idx += 1
    
while True:
    if not num_list:
        for i in sign_list:
            print(i)
        break

    elif stack[idx] == num_list[0]:
        num_list.pop(0)
        stack.pop(-1)
        sign_list.append('-')
        idx -= 1

    else:
        print('NO')
        break