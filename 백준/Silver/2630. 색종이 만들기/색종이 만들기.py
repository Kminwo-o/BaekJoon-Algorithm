import sys
input = sys.stdin.readline

# row, col을 받아서 종이의 색이 같은지 체크
def colorcheck(row, col, size):
    color = board[row][col]

    # 색이 다르다면 False를 반환
    for j in range(row, row + size):
        for k in range(col, col + size):
            if color != board[j][k]:
                return False
    # 별 일 없음 = 색이 같음, 그러면 True 반환
    return True

# 종이를 수거하거나 자르기
def partition(row, col, size):
    global white_paper
    global blue_paper
    # 색이 같다면 종이 색상에 따라 종이를 += 1
    if colorcheck(row, col, size):
        if board[row][col] == 0:
            white_paper += 1
        else:
            blue_paper += 1
        # 찾고 끝내주기
        return

    # 같지 않으면 종이 반갈
    newsize = size // 2

    partition(row, col, newsize) # (0,0,4) 좌상
    partition(row, col + newsize, newsize) # (0,4,4) 우상
    partition(row + newsize, col, newsize) # (4,0,4) 좌하
    partition(row + newsize, col + newsize, newsize) # (4,4,4) 우하

# main

N = int(input())

white_paper = 0
blue_paper = 0
board = [[0] for _ in range(N)]

for i in range(N):
    board[i] = list(map(int,input().split()))

partition(0,0,N)
print(white_paper)
print(blue_paper)