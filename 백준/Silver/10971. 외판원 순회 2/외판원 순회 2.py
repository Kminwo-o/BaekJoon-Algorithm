def dfs(start ,idx, val, cnt):
    global best_min
    if cnt == N:
        if arr[idx][start]:
            val += arr[idx][start]
            if best_min > val:
                best_min = val

    if val > best_min:
        return
    
    for i in range(N):
        if not used[i] and arr[idx][i] != 0:
            used[i] = 1
            dfs(start, i, val+arr[idx][i], cnt+1)
            used[i] = 0

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
best_min = 1e9
used = [0] * N
for i in range(N):
    val = 0
    used[i] = 1
    dfs(i, i, val, 1)
    used[i] = 0

print(best_min)