import sys
input = sys.stdin.readline

N, M, R = map(int, input().split())
arr = [[0] * M for _ in range(N)]
for i in range(N):
     arr[i] = list(map(int, input().split()))

half = min(N, M) // 2

for _ in range(R):
     for i in range(half):
        x, y = i, i
        tmp = arr[i][i]

        for j in range(i+1, N-i):
            x = j
            prev_value = arr[x][y]
            arr[x][y] = tmp
            tmp = prev_value

        for j in range(i+1, M-i):
            y = j
            prev_value = arr[x][y]
            arr[x][y] = tmp
            tmp = prev_value

        for j in range(i+1, N-i):
            x = N - j - 1
            prev_value = arr[x][y]
            arr[x][y] = tmp
            tmp = prev_value
        
        for j in range(i+1, M-i):
            y = M - j - 1
            prev_value = arr[x][y]
            arr[x][y] = tmp
            tmp = prev_value

for i in range(N):
    for j in range(M):
        print(arr[i][j], end=' ')
    print()