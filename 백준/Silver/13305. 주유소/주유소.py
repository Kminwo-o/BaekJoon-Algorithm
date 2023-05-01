N = int(input())

road = list(map(int, input().split()))
cost = list(map(int, input().split()))
ans = 0
min_cost = 1e9+1

for i in range(N-1):
    if cost[i] < min_cost:
        min_cost = cost[i]
        dis = road[i]
        ans += min_cost * dis
        
    else:
        dis = road[i]
        ans += min_cost * dis

print(ans)