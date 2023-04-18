import sys

input = sys.stdin.readline

N = int(input())
lst = list(map(int, input().split()))
lsst = [lst[0]]

for i in lst:
    if lsst[-1] < i:
        lsst.append(i)

    else:
        left = 0
        right = len(lsst)

        while left < right:
            mid = (right + left) // 2

            if lsst[mid] == i:
                right = mid
                break

            elif lsst[mid] < i:
                left = mid + 1
            else:
                right = mid

        lsst[right] = i

print(len(lsst))