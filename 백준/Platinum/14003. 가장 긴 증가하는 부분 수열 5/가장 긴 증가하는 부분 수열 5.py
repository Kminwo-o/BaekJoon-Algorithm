import sys
input = sys.stdin.readline

def binary_search(num):
    left = 0
    right = len(lsst) - 1

    while left <= right:
        mid = (left + right) // 2

        if lsst[mid] == num:
            return mid
        elif lsst[mid] < num:
            left = mid + 1
        else:
            right = mid - 1

    return left

N = int(input())
lst = list(map(int, input().split()))
lsst = [lst[0]]
dp = [(0, lst[0])]

for i in range(1, N):
    if lsst[-1] < lst[i]:
        lsst.append(lst[i])
        dp.append((len(lsst)-1, lst[i]))

    else:
        idx = binary_search(lst[i])
        lsst[idx] = lst[i]
        dp.append((idx, lst[i]))

best_cnt = len(lsst)
print(best_cnt)

ans = []
for i in range(N-1, -1, -1):
    if dp[i][0] == best_cnt-1:
        ans.append(dp[i][1])
        best_cnt -= 1

print(*ans[::-1])