import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = []
cut_board = []
 
for _ in range(N):
    board.append(input())
 
for i in range(N-7):
    for j in range(M-7):
        B = 0
        W = 0
    
        for a in range(i, i+8):
            for b in range(j, j+8):
                if (a + b) % 2 == 0:
                    if board[a][b] != 'W':
                        W += 1
                    if  board[a][b] != 'B':
                        B += 1
                else:
                    if board[a][b] != 'W':
                        B += 1
                    if  board[a][b] != 'B':
                        W += 1

        cut_board.append(B)
        cut_board.append(W)

print(min(cut_board))