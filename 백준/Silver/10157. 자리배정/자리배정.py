X, Y = map(int, input().split())

d = [(1,0), (0,1), (-1,0), (0,-1)] # 하 우 상 좌
arr = [[0] * X for _ in range(Y)]
num = 1
row = 0
col = 0
idx = 0

while num != (X*Y)+1:
    arr[row][col] = num

    row += d[idx][0]
    col += d[idx][1]
    
    if row+d[idx][0] >= Y or col+d[idx][1] >= X or arr[row+d[idx][0]][col+d[idx][1]] != 0:
        idx += 1
        if idx == 4:
            idx = 0

    num += 1

audience = int(input())

check = False
for i in range(Y):
    for j in range(X):
        if arr[i][j] == audience:
            print(j+1, i+1)
            check = True
            break
    if check == True:
        break
else:
    print(0)