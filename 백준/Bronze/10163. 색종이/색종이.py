# 색종이 장수,
# 놓이는 면적은 1001 * 1001
# 좌측 아래 꼭짓점 기준 x y 너비, 높이

N = int(input())

arr = [[0] * 1001 for _ in range(1001)]
lst = []
location = []
for _ in range(N):
    x, y, w, h = map(int,input().split())
    
    for i in range(y, h+y):
        for j in range(x, w+x):
            arr[i][j] = 1

    location.append((x, y, w, h))

ans = []

for i in range(len(location)-1,-1,-1):
    cnt = 0
    for j in range(location[i][1],location[i][3]+location[i][1]):
        for k in range(location[i][0], location[i][2]+location[i][0]):
            if arr[j][k] == 1:
                cnt += 1
                arr[j][k] = 0
    ans.append(cnt)

for i in range(len(ans)-1, -1, -1):
    print(ans[i])