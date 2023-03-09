import sys
input = sys.stdin.readline

N = int(input())
idx = 0
lst = list(map(int, input().split()))
arr = len(lst)
real = []
stack = []

while idx != arr:
    a = lst[idx]

    if stack:
        while stack:
            if stack[-1][0] < a:
                stack.pop()
                if not stack:
                    real.append(0)

            elif stack[-1][0] > a:
                real.append(stack[-1][1] + 1)
                break
            else:
                real.append(stack[-1][1] + 1)
                stack.pop()

        stack.append((a, idx))
    else:
        real.append(0)
        stack.append((a, idx))

    idx += 1

print(*real)
