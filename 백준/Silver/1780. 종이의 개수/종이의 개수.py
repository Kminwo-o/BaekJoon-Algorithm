import sys
input = sys.stdin.readline

def check(x,y,size):
    paper = arr[x][y]

    for i in range(x, x + size):
        for j in range(y, y + size):
            if paper != arr[i][j]:
                return False
    
    return True

def partition(x, y, size):
    global z0, o1, m1
    if check(x, y, size):
        if arr[x][y] == 0:
            z0 += 1
        elif arr[x][y] == 1:
            o1 += 1
        else:
            m1 += 1
        
        return
    
    new_size = size // 3
    partition(x, y, new_size)
    partition(x, y + new_size, new_size)
    partition(x, y + (2 * new_size), new_size)
    partition(x + new_size, y, new_size)
    partition(x + new_size, y + new_size, new_size)
    partition(x + new_size, y + (2 * new_size), new_size)
    partition(x + (2* new_size), y, new_size)
    partition(x + (2* new_size), y + new_size, new_size)
    partition(x + (2* new_size), y + (2 * new_size), new_size)

    return

N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]
z0 = 0
o1 = 0
m1 = 0

partition(0,0,N)
print(f'{m1}\n{z0}\n{o1}')