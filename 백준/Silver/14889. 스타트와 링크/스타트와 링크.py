import sys
input = sys.stdin.readline

def balancing(depth, idx):
    global balance
    if depth == N // 2:
        team1, team2 = 0, 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    team1 += team_lst[i][j]
                    
                elif not visited[i] and not visited[j]:
                    team2 += team_lst[i][j]
        if balance > abs(team1 - team2):
            balance = abs(team1 - team2)
        return

    for i in range(idx, N):
        if not visited[i]:
            visited[i] = 1
            balancing(depth + 1, i + 1)
            visited[i] = 0

N = int(input())

team_lst = [list(map(int, input().split())) for _ in range(N)]
visited = [0] * N
balance = 1e9
balancing(0, 0)
print(balance)