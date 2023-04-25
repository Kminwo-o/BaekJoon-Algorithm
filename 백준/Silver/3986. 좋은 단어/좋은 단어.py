N = int(input())
ans = 0

for _ in range(N):
    stack = []
    string = input()

    for i in string:
        if stack and stack[-1] == i:
            stack.pop()
        else:
            stack.append(i)

    if not stack:
        ans += 1

print(ans)
