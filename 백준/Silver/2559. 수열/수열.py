import sys
input = sys.stdin.readline

N, K = map(int,input().split())

lst = list(map(int, input().split()))
max_lst = [sum(lst[:K])]
ans = sum(lst[:K])

for i in range(N-K):
    ans = ans - lst[i] + lst[i+K]
    max_lst.append(ans)
    
print(max(max_lst))