# 색종이 장수,
# 놓이는 면적은 1001 * 1001
# 좌측 아래 꼭짓점 기준 x y 너비, 높이

N = int(input())

arr = [[0] * 1001 for _ in range(1001)]
lst = []
location = []
for l in range(1,N+1):
    x, y, w, h = map(int,input().split())

    for i in range(y, h+y):
        for j in range(x, w+x):
            arr[i][j] = l

ans = [0] * (N+1)

for i in range(1001):
    for j in range(1001):
        if arr[i][j]:
            ans[arr[i][j]] += 1

for i in range(1,N+1):
    print(ans[i])