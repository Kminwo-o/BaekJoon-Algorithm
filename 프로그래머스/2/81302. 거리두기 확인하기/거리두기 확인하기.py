dir = [[-1, 0], [1, 0], [0, 1], [0, -1]]

def dfs(now, depth, arr, visited):
    visited[now[0]][now[1]] = 1

    if (depth == 2):
        return False

    for i in dir:
        nx = now[0] + i[0]
        ny = now[1] + i[1]

        if (0 <= nx < 5 and 0 <= ny < 5 and not visited[nx][ny]):
            if(arr[nx][ny] == "O"):
                if (dfs([nx, ny], depth+1, arr, visited)):
                    return True
            elif (arr[nx][ny] == "P"):
                return True
            
    return False

def solution(places):
    answer = [1] * 5
    for i in range(5):
        arr = [[] for _ in range(5)]
        for j in range(5):
            arr[j] = list(places[i][j])
        
        for j in range(5):
            if (answer[i] == 0):
                break
            for k in range(5):
                if (arr[j][k] == "P"):
                    if (dfs([j,k], 0, arr, [[0] * 5 for _ in range(5)])):
                        answer[i] = 0
    
    return answer