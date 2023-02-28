import sys
input = sys.stdin.readline

N = int(input())
N_lst = list(map(int, input().split()))
M = int(input())
M_lst = list(map(int, input().split()))

N_lst.sort()
i_exist = []

for i in range(M):
    left = 0
    right = N-1
    
    while left <= right:
        mid = (left + right) // 2
        
        if N_lst[mid] == M_lst[i]:
            i_exist.append('1')
            break
        
        if N_lst[mid] <= M_lst[i]:
            left = mid + 1
        else:
            right = mid -1
    else:
        i_exist.append('0')
    
print(*i_exist)