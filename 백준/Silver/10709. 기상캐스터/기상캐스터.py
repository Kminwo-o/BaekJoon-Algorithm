import sys
input = sys.stdin.readline

H,W = map(int,input().split())

arr = [list(input().strip()) for _ in range(H)]

for i in range(H):
    for j in range(W):
        if arr[i][j] == 'c':
            arr[i][j] = 0
        else:            
            if arr[i][j] == '.':
                if j > 0 and arr[i][j-1] != -1:
                    arr[i][j] = arr[i][j-1] + 1
                
                else:
                    arr[i][j] = -1
                    
for i in range(H):
    print(*arr[i])