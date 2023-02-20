def ispromising(row):
    for i in range(row):
        if board[row] == board[i] or abs(board[row]- board[i]) == abs(row-i):
            return False
    return True

def nqueen(row):
    global cnt
    if row == N:
        cnt += 1
        return
    else:
        for i in range(N):
            board[row] = i
            if ispromising(row):
                nqueen(row+1)

N = int(input())
board = [0] * N
cnt = 0
nqueen(0)
print(cnt)