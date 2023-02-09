import sys
input = sys.stdin.readline

# row, col을 받아서 같은지 체크
def dotcheck(row, col, size):
    dot = board[row][col]

    # 다르다면 False를 반환
    for j in range(row, row + size):
        for k in range(col, col + size):
            if dot != board[j][k]:
                return False
    # 별 일 없음 = 점이 같음, 그러면 True 반환
    return True

# 영상을을 수거하거나 자르기
def partition(row, col, size):
    # 점이 같다면 점 종류에 따라 종이를 += 1
    if dotcheck(row, col, size):
        if board[row][col] == '0':
            print('0',end='')
        else:
            print('1',end='')
        return

    # 같지 않으면반갈
    newsize = size // 2
    print('(', end='')
    partition(row, col, newsize) # (0,0,4) 좌상
    partition(row, col + newsize, newsize) # (0,4,4) 우상
    partition(row + newsize, col, newsize) # (4,0,4) 좌하
    partition(row + newsize, col + newsize, newsize) # (4,4,4) 우하
    print(')',end='')

# main
N = int(input())

board = [input() for i in range(N)]

partition(0,0,N)