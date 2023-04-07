import sys
input = sys.stdin.readline
import copy 

def game(arr, i):
    if i == 0: # 상
        for j in range(N):
            v = 0
            # 상, 하로 움직일 때는 행이 움직여야 하기 때문에 index바꿔서 적기 
            for k in range(1, N):
                if arr[k][j]:
                    # 값을 빼서 저장
                    tmp = arr[k][j]
                    arr[k][j] = 0

                    # 정점 값이 비어있다면 정점으로 값 저장 
                    if arr[v][j] == 0:
                        arr[v][j] = tmp
                    # 정점 값이 같다면, *2해서 정점으로 값 저장
                    elif arr[v][j] == tmp:
                        arr[v][j] = tmp * 2
                        # 한 번에 2번 합쳐질 수 없으므로 한칸 올려주기
                        v += 1
                    # 비어있지 않지만 같지도 않을 땐, 합칠 수 없으므로 한 칸 올려서 값 저장
                    else:
                        v += 1
                        arr[v][j] = tmp
    
    elif i == 1: # 하
        for j in range(N):
            v = N-1
            for k in range(N-2, -1, -1):
                if arr[k][j]:
                    # 값을 빼서 저장
                    tmp = arr[k][j]
                    arr[k][j] = 0

                    # 정점 값이 비어있다면 정점으로 값 저장 
                    if arr[v][j] == 0:
                        arr[v][j] = tmp
                    # 정점 값이 같다면, *2해서 정점으로 값 저장
                    elif arr[v][j] == tmp:
                        arr[v][j] = tmp * 2
                        # 한 번에 2번 합쳐질 수 없으므로 한칸 올려주기
                        v -= 1
                    # 비어있지 않지만 같지도 않을 땐, 합칠 수 없으므로 한 칸 올려서 값 저장
                    else:
                        v -= 1
                        arr[v][j] = tmp
    
    elif i == 2: # 좌
        for j in range(N):
            v = 0
            for k in range(1, N):
                if arr[j][k]:
                    # 값을 빼서 저장
                    tmp = arr[j][k]
                    arr[j][k] = 0

                    # 정점 값이 비어있다면 정점으로 값 저장 
                    if arr[j][v] == 0:
                        arr[j][v] = tmp
                    # 정점 값이 같다면, *2해서 정점으로 값 저장
                    elif arr[j][v] == tmp:
                        arr[j][v] = tmp * 2
                        # 한 번에 2번 합쳐질 수 없으므로 한칸 올려주기
                        v += 1
                    # 비어있지 않지만 같지도 않을 땐, 합칠 수 없으므로 한 칸 올려서 값 저장
                    else:
                        v += 1
                        arr[j][v] = tmp

    elif i == 3: # 우
        for j in range(N):
            v = N-1
            for k in range(N-2, -1, -1):
                if arr[j][k]:
                    # 값을 빼서 저장
                    tmp = arr[j][k]
                    arr[j][k] = 0

                    # 정점 값이 비어있다면 정점으로 값 저장 
                    if arr[j][v] == 0:
                        arr[j][v] = tmp
                    # 정점 값이 같다면, *2해서 정점으로 값 저장
                    elif arr[j][v] == tmp:
                        arr[j][v] = tmp * 2
                        # 한 번에 2번 합쳐질 수 없으므로 한칸 올려주기
                        v -= 1
                    # 비어있지 않지만 같지도 않을 땐, 합칠 수 없으므로 한 칸 올려서 값 저장
                    else:
                        v -= 1
                        arr[j][v] = tmp
    
    return arr

def sovle(board, cnt):
    global best_value
    if cnt == 5:
        for i in board:
            best_value = max(max(i), best_value)
        return

    for i in range(4):
        tmp_arr = game(copy.deepcopy(board), i)
        sovle(tmp_arr, cnt + 1)
    
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
best_value = 0

sovle(arr, 0)

print(best_value)