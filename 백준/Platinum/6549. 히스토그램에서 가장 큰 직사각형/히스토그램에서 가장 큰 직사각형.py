while 1:
    lst = list(map(int, input().split()))
    if lst[0] == 0:
        break

    N = lst[0]
    lst = lst[1:]
    stack = []
    max_v = 0
    for i in range(N):
        idx = i
        while stack and stack[-1][1] > lst[i]:
            idx, height = stack.pop()
            rst = (i - idx) * height 
            max_v = max(max_v, rst)
        stack.append((idx, lst[i]))

    while stack:
        idx, height = stack.pop()
        rst = (N - idx) * height
        max_v = max(max_v, rst)
    print(max_v)